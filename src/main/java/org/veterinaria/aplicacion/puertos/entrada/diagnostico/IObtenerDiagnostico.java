package org.veterinaria.aplicacion.puertos.entrada.diagnostico;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/diagnostico")
public interface IObtenerDiagnostico {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getDiagnostico();
}
