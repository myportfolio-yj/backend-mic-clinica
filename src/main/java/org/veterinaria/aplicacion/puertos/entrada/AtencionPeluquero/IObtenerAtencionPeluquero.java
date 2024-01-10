package org.veterinaria.aplicacion.puertos.entrada.AtencionPeluquero;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencionpeluquero")
public interface IObtenerAtencionPeluquero {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getAtencionPeluquero();
}
