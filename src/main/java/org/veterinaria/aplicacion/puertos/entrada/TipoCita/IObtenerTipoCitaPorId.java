package org.veterinaria.aplicacion.puertos.entrada.TipoCita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipocita")
public interface IObtenerTipoCitaPorId {
  @GET
  @Path("/{idTipoCita}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getTipoCitaPorId(@PathParam("idTipoCita") String idTipoCita);
}
