package org.veterinaria.aplicacion.puertos.entrada.tipocita;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaActualizar;

@Path("/tipocita")
public interface IActualizarTipoCita {
  @PUT
  @Path("/{idTipoCita}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putTipoCita(@PathParam("idTipoCita") String idTipoCita, TipoCitaActualizar tipoCita);
}