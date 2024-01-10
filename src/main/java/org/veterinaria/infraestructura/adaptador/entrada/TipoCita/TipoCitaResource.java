package org.veterinaria.infraestructura.adaptador.entrada.TipoCita;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.TipoCita.ITipoCitaResource;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;
import org.veterinaria.dominio.servicio.TipoCita.ITipoCitaServicio;

public class TipoCitaResource implements ITipoCitaResource {
  @Inject
  ITipoCitaServicio servicio;

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
