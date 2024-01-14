package org.veterinaria.aplicacion.puertos.entrada.Turno;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/turno")
public interface IObtenerTurnoPorId {
  @GET
  @Path("/{idTurno}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getTurnoPorId(@PathParam("idTurno") String idTurno);
}
