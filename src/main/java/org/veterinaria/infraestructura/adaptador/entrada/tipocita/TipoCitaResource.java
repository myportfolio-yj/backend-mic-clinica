package org.veterinaria.infraestructura.adaptador.entrada.tipocita;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.tipocita.ITipoCitaResource;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;
import org.veterinaria.dominio.servicio.tipocita.ITipoCitaServicio;

public class TipoCitaResource implements ITipoCitaResource {
  private final ITipoCitaServicio servicio;

  @Inject
  public TipoCitaResource(ITipoCitaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response putTipoCita(@NotNull String idTipoCita, TipoCitaActualizar tipoCita) {
    TipoCitaSalida tipoCitaSalida = servicio.actualizarTipoCita(idTipoCita, tipoCita);
    return Response.ok(tipoCitaSalida).build();
  }

  @Override
  public Response postTipoCita(TipoCitaCrear tipoCita) {
    TipoCitaSalida tipoCitaSalida = servicio.crearTipoCita(tipoCita);
    return Response.status(Response.Status.CREATED).entity(tipoCitaSalida).build();
  }

  @Override
  public Response deleteTipoCita(@NotNull String idTipoCita) {
    TipoCitaSalida tipoCitaSalida = servicio.eliminarTipoCita(idTipoCita);
    return Response.status(Response.Status.CREATED).entity(tipoCitaSalida).build();
  }

  @Override
  public Response getTipoCita() {
    return Response.ok(servicio.obtenerTipoCita()).build();
  }

  @Override
  public Response getTipoCitaPorId(@NotNull String idTipoCita) {
    return Response.ok(servicio.obtenerTipoCitaPorId(idTipoCita)).build();
  }
}
