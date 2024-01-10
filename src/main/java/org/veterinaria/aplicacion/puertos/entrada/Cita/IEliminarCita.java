package org.veterinaria.aplicacion.puertos.entrada.Cita;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/cita")
public interface IEliminarCita {
  @DELETE
  @Path("/{idCita}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteCita(@PathParam("idCita") String idCita);
}
