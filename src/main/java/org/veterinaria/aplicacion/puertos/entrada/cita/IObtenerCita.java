package org.veterinaria.aplicacion.puertos.entrada.cita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cita")
public interface IObtenerCita {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getCita();
}
