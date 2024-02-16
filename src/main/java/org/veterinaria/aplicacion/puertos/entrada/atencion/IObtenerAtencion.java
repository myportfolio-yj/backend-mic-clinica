package org.veterinaria.aplicacion.puertos.entrada.atencion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/atencion")
public interface IObtenerAtencion {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getAtencion();
}
