package org.veterinaria.aplicacion.puertos.entrada.turno;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/turno")
public interface IEliminarTurno {
  @DELETE
  @Path("/{idTurno}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteTurno(@PathParam("idTurno") String idTurno);
}
