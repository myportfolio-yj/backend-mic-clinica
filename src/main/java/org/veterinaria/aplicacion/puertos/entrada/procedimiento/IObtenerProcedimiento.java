package org.veterinaria.aplicacion.puertos.entrada.procedimiento;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/procedimiento")
public interface IObtenerProcedimiento {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getProcedimiento();
}
