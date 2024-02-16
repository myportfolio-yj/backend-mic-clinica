package org.veterinaria.aplicacion.puertos.entrada.atencion;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencion")
public interface IEliminarAtencion {
  @DELETE
  @Path("/{idAtencion}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteAtencion(@PathParam("idAtencion") String idAtencion);
}
