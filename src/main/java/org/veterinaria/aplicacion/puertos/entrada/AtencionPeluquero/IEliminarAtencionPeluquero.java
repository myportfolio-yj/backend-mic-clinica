package org.veterinaria.aplicacion.puertos.entrada.AtencionPeluquero;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencionpeluquero")
public interface IEliminarAtencionPeluquero {
  @DELETE
  @Path("/{idAtencionPeluquero}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteAtencionPeluquero(@PathParam("idAtencionPeluquero") String idAtencionPeluquero);
}
