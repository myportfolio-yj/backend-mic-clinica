package org.veterinaria.dominio.servicio.tipocita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.tipocita.ITipoCitaRepositorio;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaEntidad;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;

import java.util.List;

@ApplicationScoped
public class TipoCitaServicio implements ITipoCitaServicio {
  private final ITipoCitaRepositorio repositorio;

  @Inject
  public TipoCitaServicio(ITipoCitaRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public TipoCitaSalida obtenerTipoCitaPorId(String idTipoCita) {
    TipoCitaEntidad tipoCitaEntidad = repositorio.obtenerTipoCitaPorId(idTipoCita);
    return TipoCitaSalida.builder()
          .id(tipoCitaEntidad.id.toString())
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
    return this.obtenerTipoCitaPorId(tipoCitaEntidad.id.toString());
  }

  @Override
  public TipoCitaSalida eliminarTipoCita(String idTipoCita) {
    TipoCitaEntidad tipoCitaEntidad = repositorio.eliminarTipoCita(idTipoCita);
    return TipoCitaSalida.builder()
          .id(tipoCitaEntidad.id.toString())
          .tipoCita(tipoCitaEntidad.getTipoCita())
          .build();
  }

  @Override
  public List<TipoCitaSalida> obtenerTipoCita() {
    List<TipoCitaEntidad> tipoCita = repositorio.obtenerTodosTipoCita();
    return tipoCita.parallelStream().map(p -> TipoCitaSalida.builder()
                .id(p.id.toString())
                .tipoCita(p.getTipoCita())
                .build())
          .toList();
  }
}
