package org.veterinaria.aplicacion.puertos.entrada.receta;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/receta")
public interface IEliminarReceta {
  @DELETE
  @Path("/{idReceta}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteReceta(@PathParam("idReceta") String idReceta);
}
