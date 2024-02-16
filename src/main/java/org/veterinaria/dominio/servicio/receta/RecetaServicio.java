package org.veterinaria.dominio.servicio.receta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.cita.ICitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.receta.IRecetaRepositorio;
import org.veterinaria.dominio.modelo.cita.CitaEntidad;
import org.veterinaria.dominio.modelo.receta.RecetaActualizar;
import org.veterinaria.dominio.modelo.receta.RecetaCrear;
import org.veterinaria.dominio.modelo.receta.RecetaEntidad;
import org.veterinaria.dominio.modelo.receta.RecetaSalida;
import org.veterinaria.dominio.servicio.medicamento.IMedicamentoServicio;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RecetaServicio implements IRecetaServicio {
  private final IRecetaRepositorio repositorio;
  private final ICitaRepositorio repositorioCita;
  private final IMedicamentoServicio servicio;

  @Inject
  public RecetaServicio(IRecetaRepositorio repositorio, ICitaRepositorio repositorioCita, IMedicamentoServicio servicio) {
    this.repositorio = repositorio;
    this.repositorioCita = repositorioCita;
    this.servicio = servicio;
  }

  @Override
  public RecetaSalida actualizarReceta(String idReceta, RecetaActualizar receta) {
    RecetaEntidad recetaEntidad = new RecetaEntidad();
    recetaEntidad.setCantidad(receta.getCantidad());
    recetaEntidad.setDosis(receta.getDosis());
    recetaEntidad.setIndicaciones(receta.getIndicaciones());
    repositorio.actualizarReceta(idReceta, recetaEntidad);
    return this.obtenerRecetaPorId(idReceta);
  }

  @Override
  public RecetaSalida crearReceta(RecetaCrear receta) {
    CitaEntidad citaEntidad = repositorioCita.obtenerCitaPorId(receta.getIdCita());

    RecetaEntidad recetaEntidad = new RecetaEntidad();
    recetaEntidad.setIdCita(receta.getIdCita());
    recetaEntidad.setIdMedicamento(receta.getIdMedicamento());
    recetaEntidad.setCantidad(receta.getCantidad());
    recetaEntidad.setDosis(receta.getDosis());
    recetaEntidad.setIndicaciones(receta.getIndicaciones());
    recetaEntidad = repositorio.crearReceta(recetaEntidad);
    if (citaEntidad.getRecetas() == null) {
      List<String> recetas = new ArrayList<String>();
      recetas.add(recetaEntidad.id.toString());
      citaEntidad.setRecetas(recetas);
    } else {
      citaEntidad.getRecetas().add(recetaEntidad.id.toString());
    }
    repositorioCita.actualizarCita(citaEntidad.id.toString(), citaEntidad);

    return this.obtenerRecetaPorId(recetaEntidad.id.toString());
  }

  @Override
  public RecetaSalida eliminarReceta(String idReceta) {
    RecetaEntidad recetaEntidad = repositorio.eliminarReceta(idReceta);
    return RecetaSalida.builder()
          .id(recetaEntidad.id.toString())
          .idCita(recetaEntidad.getIdCita())
          .idMedicamento(recetaEntidad.getIdMedicamento())
          .medicamento(servicio.obtenerMedicamentoPorId(recetaEntidad.getIdMedicamento()))
          .cantidad(recetaEntidad.getCantidad())
          .dosis(recetaEntidad.getDosis())
          .indicaciones(recetaEntidad.getIndicaciones())
          .build();
  }

  @Override
  public RecetaSalida obtenerRecetaPorId(String idReceta) {
    RecetaEntidad recetaEntidad = repositorio.obtenerRecetaPorId(idReceta);
    return RecetaSalida.builder()
          .id(recetaEntidad.id.toString())
          .idCita(recetaEntidad.getIdCita())
          .idMedicamento(recetaEntidad.getIdMedicamento())
          .medicamento(servicio.obtenerMedicamentoPorId(recetaEntidad.getIdMedicamento()))
          .cantidad(recetaEntidad.getCantidad())
          .dosis(recetaEntidad.getDosis())
          .indicaciones(recetaEntidad.getIndicaciones())
          .build();
  }

  @Override
  public List<RecetaSalida> obtenerReceta() {
    List<RecetaEntidad> recetaEntidads = repositorio.obtenerTodosReceta();
    return recetaEntidads.parallelStream().map(p -> RecetaSalida.builder()
                .id(p.id.toString())
                .idCita(p.getIdCita())
                .idMedicamento(p.getIdMedicamento())
                .medicamento(servicio.obtenerMedicamentoPorId(p.getIdMedicamento()))
                .cantidad(p.getCantidad())
                .dosis(p.getDosis())
                .indicaciones(p.getIndicaciones())
                .build())
          .toList();
  }

  @Override
  public List<RecetaSalida> obtenerRecetaPorIdCita(String idCita) {
    List<RecetaEntidad> recetaEntidads = repositorio.obtenerRecetaPorIdCita(idCita);
    return recetaEntidads.parallelStream().map(p -> RecetaSalida.builder()
                .id(p.id.toString())
                .idCita(p.getIdCita())
                .idMedicamento(p.getIdMedicamento())
                .medicamento(servicio.obtenerMedicamentoPorId(p.getIdMedicamento()))
                .cantidad(p.getCantidad())
                .dosis(p.getDosis())
                .indicaciones(p.getIndicaciones())
                .build())
          .toList();
  }
}
