package org.veterinaria.aplicacion.puertos.entrada.atencionpeluquero;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencionpeluquero")
public interface IObtenerAtencionPeluqueroPorId {
  @GET
  @Path("/{idAtencionPeluquero}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getAtencionPeluqueroPorId(@PathParam("idAtencionPeluquero") String idAtencionPeluquero);
}
