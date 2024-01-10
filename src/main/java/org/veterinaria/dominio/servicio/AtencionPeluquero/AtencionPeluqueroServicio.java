package org.veterinaria.dominio.servicio.AtencionPeluquero;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.AtencionPeluquero.IAtencionPeluqueroRepositorio;
import org.veterinaria.aplicacion.puertos.salida.TipoCita.ITipoCitaRepositorio;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroEntidad;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

import java.util.List;

@ApplicationScoped
public class AtencionPeluqueroServicio implements IAtencionPeluqueroServicio {
  @Inject
  IAtencionPeluqueroRepositorio repositorio;

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
    return this.obtenerAtencionPeluqueroPorId(atencionPeluqueroEntidad.getId().toString());
  }

  @Override
  public AtencionPeluqueroSalida eliminarAtencionPeluquero(String idAtencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = repositorio.eliminarAtencionPeluquero(idAtencionPeluquero);
    return AtencionPeluqueroSalida.builder()
          .id(atencionPeluqueroEntidad.getId().toString())
          .atencionPeluquero(atencionPeluqueroEntidad.getAtencionPeluquero())
          .build();
  }

  @Override
  public AtencionPeluqueroSalida obtenerAtencionPeluqueroPorId(String idAtencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = repositorio.obtenerAtencionPeluqueroPorId(idAtencionPeluquero);
    return AtencionPeluqueroSalida.builder()
          .id(atencionPeluqueroEntidad.getId().toString())
          .atencionPeluquero(atencionPeluqueroEntidad.getAtencionPeluquero())
          .build();
  }

  @Override
  public List<AtencionPeluqueroSalida> obtenerAtencionPeluquero() {
    List<AtencionPeluqueroEntidad> atencionPeluqueroEntidads = repositorio.obtenerTodosAtencionPeluquero();
    return atencionPeluqueroEntidads.parallelStream().map(p -> AtencionPeluqueroSalida.builder()
                .id(p.getId().toString())
                .atencionPeluquero(p.getAtencionPeluquero())
                .build())
          .toList();
  }
}
