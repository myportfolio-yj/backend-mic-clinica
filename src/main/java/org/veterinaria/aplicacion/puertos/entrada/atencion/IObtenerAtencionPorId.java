package org.veterinaria.aplicacion.puertos.entrada.atencion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencion")
public interface IObtenerAtencionPorId {
  @GET
  @Path("/{idAtencion}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getAtencionPorId(@PathParam("idAtencion") String idAtencion);
}
