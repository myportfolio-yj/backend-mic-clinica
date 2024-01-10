package org.veterinaria.dominio.servicio.TipoCita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.TipoCita.ITipoCitaRepositorio;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

import java.util.List;

@ApplicationScoped
public class TipoCitaServicio implements ITipoCitaServicio {
  @Inject
  ITipoCitaRepositorio repositorio;

  @Override
  public TipoCitaSalida obtenerTipoCitaPorId(String idTipoCita) {
    TipoCitaEntidad tipoCitaEntidad = repositorio.obtenerTipoCitaPorId(idTipoCita);
    return TipoCitaSalida.builder()
          .id(tipoCitaEntidad.getId().toString())
          .tipoCita(tipoCitaEntidad.getTipoCita())
          .build();
  }

  @Override
  public TipoCitaSalida actualizarTipoCita(String idTipoCita, TipoCitaActualizar tipoCita) {
    TipoCitaEntidad tipoCitaEntidad = new TipoCitaEntidad();
    tipoCitaEntidad.setTipoCita(tipoCita.getTipoCita());
    repositorio.actualizarTipoCita(idTipoCita, tipoCitaEntidad);
    return this.obtenerTipoCitaPorId(idTipoCita);
  }

  @Override
  public TipoCitaSalida crearTipoCita(TipoCitaCrear tipoCita) {
    TipoCitaEntidad tipoCitaEntidad = new TipoCitaEntidad();
    tipoCitaEntidad.setTipoCita(tipoCita.getTipoCita());
    tipoCitaEntidad = repositorio.crearTipoCita(tipoCitaEntidad);
    return this.obtenerTipoCitaPorId(tipoCitaEntidad.getId().toString());
  }

  @Override
  public TipoCitaSalida eliminarTipoCita(String idTipoCita) {
    TipoCitaEntidad tipoCitaEntidad = repositorio.eliminarTipoCita(idTipoCita);
    return TipoCitaSalida.builder()
          .id(tipoCitaEntidad.getId().toString())
          .tipoCita(tipoCitaEntidad.getTipoCita())
          .build();
  }

  @Override
  public List<TipoCitaSalida> obtenerTipoCita() {
    List<TipoCitaEntidad> tipoCita = repositorio.obtenerTodosTipoCita();
    return tipoCita.parallelStream().map(p -> TipoCitaSalida.builder()
                .id(p.getId().toString())
                .tipoCita(p.getTipoCita())
                .build())
          .toList();
  }
}
