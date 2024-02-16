package org.veterinaria.aplicacion.puertos.entrada.historias;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historial")
public interface IObtenerHistoria {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getHistorial();
}
