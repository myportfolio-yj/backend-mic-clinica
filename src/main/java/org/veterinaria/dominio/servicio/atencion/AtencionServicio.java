package org.veterinaria.dominio.servicio.atencion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.atencion.IAtencionRepositorio;
import org.veterinaria.aplicacion.puertos.salida.cita.ICitaRepositorio;
import org.veterinaria.dominio.modelo.atencion.AtencionActualizar;
import org.veterinaria.dominio.modelo.atencion.AtencionCrear;
import org.veterinaria.dominio.modelo.atencion.AtencionEntidad;
import org.veterinaria.dominio.modelo.atencion.AtencionSalida;
import org.veterinaria.dominio.modelo.cita.CitaEntidad;

import java.util.List;

@ApplicationScoped
public class AtencionServicio implements IAtencionServicio {
  private final IAtencionRepositorio repositorio;
  private final ICitaRepositorio repositorioCita;

  @Inject
  public AtencionServicio(IAtencionRepositorio repositorio, ICitaRepositorio repositorioCita) {
    this.repositorio = repositorio;
    this.repositorioCita = repositorioCita;
  }

  @Override
  public AtencionSalida actualizarAtencion(String idAtencion, AtencionActualizar atencion) {
    AtencionEntidad atencionEntidad = new AtencionEntidad();
    atencionEntidad.setMotivo(atencion.getMotivo());
    atencionEntidad.setPeso(atencion.getPeso());
    atencionEntidad.setTemperatura(atencion.getTemperatura());
    atencionEntidad.setFrecuenciaRespiratoria(atencion.getFrecuenciaRespiratoria());
    atencionEntidad.setFrecuenciaCardiaca(atencion.getFrecuenciaCardiaca());
    atencionEntidad.setIdDiagnostico(atencion.getIdDiagnostico());
    atencionEntidad.setIdProcedimiento(atencion.getIdProcedimiento());
    atencionEntidad.setDetalleDiagnostico(atencion.getDetalleDiagnostico());
    atencionEntidad.setDetalleProcedimiento(atencion.getDetalleProcedimiento());
    atencionEntidad.setCerrado(atencion.getCerrado());
    repositorio.actualizarAtencion(idAtencion, atencionEntidad);
    return this.obtenerAtencionPorId(idAtencion);
  }

  @Override
  public AtencionSalida crearAtencion(AtencionCrear atencion) {
    CitaEntidad citaEntidad = repositorioCita.obtenerCitaPorId(atencion.getIdCita());

    AtencionEntidad atencionEntidad = new AtencionEntidad();
    atencionEntidad.setIdCita(atencion.getIdCita());
    atencionEntidad.setMotivo(atencion.getMotivo());
    atencionEntidad.setPeso(atencion.getPeso());
    atencionEntidad.setTemperatura(atencion.getTemperatura());
    atencionEntidad.setFrecuenciaRespiratoria(atencion.getFrecuenciaRespiratoria());
    atencionEntidad.setFrecuenciaCardiaca(atencion.getFrecuenciaCardiaca());
    atencionEntidad.setIdDiagnostico(atencion.getIdDiagnostico());
    atencionEntidad.setIdProcedimiento(atencion.getIdProcedimiento());
    atencionEntidad.setDetalleDiagnostico(atencion.getDetalleDiagnostico());
    atencionEntidad.setDetalleProcedimiento(atencion.getDetalleProcedimiento());
    atencionEntidad.setCerrado(atencion.getCerrado());
    atencionEntidad = repositorio.crearAtencion(atencionEntidad);

    citaEntidad.setIdAtencion(atencionEntidad.id.toString());
    repositorioCita.actualizarCita(citaEntidad.id.toString(), citaEntidad);

    return this.obtenerAtencionPorId(atencionEntidad.id.toString());
  }

  @Override
  public AtencionSalida eliminarAtencion(String idAtencion) {
    AtencionEntidad atencionEntidad = repositorio.eliminarAtencion(idAtencion);
    return AtencionSalida.builder()
          .id(atencionEntidad.id.toString())
          .idCita(atencionEntidad.getIdCita())
          .motivo(atencionEntidad.getMotivo())
          .peso(atencionEntidad.getPeso())
          .temperatura(atencionEntidad.getTemperatura())
          .frecuenciaRespiratoria(atencionEntidad.getFrecuenciaRespiratoria())
          .frecuenciaCardiaca(atencionEntidad.getFrecuenciaCardiaca())
          .idDiagnostico(atencionEntidad.getIdDiagnostico())
          .idProcedimiento(atencionEntidad.getIdProcedimiento())
          .detalleDiagnostico(atencionEntidad.getDetalleDiagnostico())
          .detalleProcedimiento(atencionEntidad.getDetalleProcedimiento())
          .cerrado(atencionEntidad.getCerrado())
          .build();
  }

  @Override
  public AtencionSalida obtenerAtencionPorId(String idAtencion) {
    AtencionEntidad atencionEntidad = repositorio.obtenerAtencionPorId(idAtencion);
    return AtencionSalida.builder()
          .id(atencionEntidad.id.toString())
          .idCita(atencionEntidad.getIdCita())
          .motivo(atencionEntidad.getMotivo())
          .peso(atencionEntidad.getPeso())
          .temperatura(atencionEntidad.getTemperatura())
          .frecuenciaRespiratoria(atencionEntidad.getFrecuenciaRespiratoria())
          .frecuenciaCardiaca(atencionEntidad.getFrecuenciaCardiaca())
          .idDiagnostico(atencionEntidad.getIdDiagnostico())
          .idProcedimiento(atencionEntidad.getIdProcedimiento())
          .detalleDiagnostico(atencionEntidad.getDetalleDiagnostico())
          .detalleProcedimiento(atencionEntidad.getDetalleProcedimiento())
          .cerrado(atencionEntidad.getCerrado())
          .build();
  }

  @Override
  public List<AtencionSalida> obtenerAtencion() {
    List<AtencionEntidad> atencionEntidads = repositorio.obtenerTodosAtencion();
    return atencionEntidads.parallelStream().map(p -> AtencionSalida.builder()
                .id(p.id.toString())
                .idCita(p.getIdCita())
                .motivo(p.getMotivo())
                .peso(p.getPeso())
                .temperatura(p.getTemperatura())
                .frecuenciaRespiratoria(p.getFrecuenciaRespiratoria())
                .frecuenciaCardiaca(p.getFrecuenciaCardiaca())
                .idDiagnostico(p.getIdDiagnostico())
                .idProcedimiento(p.getIdProcedimiento())
                .detalleDiagnostico(p.getDetalleDiagnostico())
                .detalleProcedimiento(p.getDetalleProcedimiento())
                .cerrado(p.getCerrado())
                .build())
          .toList();
  }
}
