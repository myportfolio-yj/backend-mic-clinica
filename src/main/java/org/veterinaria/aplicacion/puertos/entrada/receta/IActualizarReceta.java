package org.veterinaria.aplicacion.puertos.entrada.receta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.receta.RecetaActualizar;

@Path("/receta")
public interface IActualizarReceta {
  @PUT
  @Path("/{idReceta}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putReceta(@PathParam("idReceta") String idReceta, RecetaActualizar recetaActualizar);
}