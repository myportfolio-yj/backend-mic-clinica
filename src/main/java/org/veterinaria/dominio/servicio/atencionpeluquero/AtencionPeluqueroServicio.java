package org.veterinaria.dominio.servicio.atencionpeluquero;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.atencionpeluquero.IAtencionPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroEntidad;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

import java.util.List;

@ApplicationScoped
public class AtencionPeluqueroServicio implements IAtencionPeluqueroServicio {
  private final IAtencionPeluqueroRepositorio repositorio;

  @Inject
  public AtencionPeluqueroServicio(IAtencionPeluqueroRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public AtencionPeluqueroSalida actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = new AtencionPeluqueroEntidad();
    atencionPeluqueroEntidad.setAtencionPeluquero(atencionPeluquero.getAtencionPeluquero());
    repositorio.actualizarAtencionPeluquero(idAtencionPeluquero, atencionPeluqueroEntidad);
    return this.obtenerAtencionPeluqueroPorId(idAtencionPeluquero);
  }

  @Override
  public AtencionPeluqueroSalida crearAtencionPeluquero(AtencionPeluqueroCrear atencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = new AtencionPeluqueroEntidad();
    atencionPeluqueroEntidad.setAtencionPeluquero(atencionPeluquero.getAtencionPeluquero());
    atencionPeluqueroEntidad = repositorio.crearAtencionPeluquero(atencionPeluqueroEntidad);
    return this.obtenerAtencionPeluqueroPorId(atencionPeluqueroEntidad.id.toString());
  }

  @Override
  public AtencionPeluqueroSalida eliminarAtencionPeluquero(String idAtencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = repositorio.eliminarAtencionPeluquero(idAtencionPeluquero);
    return AtencionPeluqueroSalida.builder()
          .id(atencionPeluqueroEntidad.id.toString())
          .atencionPeluquero(atencionPeluqueroEntidad.getAtencionPeluquero())
          .build();
  }

  @Override
  public AtencionPeluqueroSalida obtenerAtencionPeluqueroPorId(String idAtencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = repositorio.obtenerAtencionPeluqueroPorId(idAtencionPeluquero);
    return AtencionPeluqueroSalida.builder()
          .id(atencionPeluqueroEntidad.id.toString())
          .atencionPeluquero(atencionPeluqueroEntidad.getAtencionPeluquero())
          .build();
  }

  @Override
  public List<AtencionPeluqueroSalida> obtenerAtencionPeluquero() {
    List<AtencionPeluqueroEntidad> atencionPeluqueroEntidads = repositorio.obtenerTodosAtencionPeluquero();
    return atencionPeluqueroEntidads.parallelStream().map(p -> AtencionPeluqueroSalida.builder()
                .id(p.id.toString())
                .atencionPeluquero(p.getAtencionPeluquero())
                .build())
          .toList();
  }
}
