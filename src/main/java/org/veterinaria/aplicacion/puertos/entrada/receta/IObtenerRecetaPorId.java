package org.veterinaria.aplicacion.puertos.entrada.receta;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/receta")
public interface IObtenerRecetaPorId {
  @GET
  @Path("/{idReceta}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getRecetaPorId(@PathParam("idReceta") String idReceta);
}
