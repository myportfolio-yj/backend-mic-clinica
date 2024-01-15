package org.veterinaria.aplicacion.puertos.entrada.tipocita;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipocita")
public interface IEliminarTipoCita {
  @DELETE
  @Path("/{idTipoCita}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteTipoCita(@PathParam("idTipoCita") String idTipoCita);
}
