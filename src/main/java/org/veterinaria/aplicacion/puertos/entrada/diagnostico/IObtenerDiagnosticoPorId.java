package org.veterinaria.aplicacion.puertos.entrada.diagnostico;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/diagnostico")
public interface IObtenerDiagnosticoPorId {
  @GET
  @Path("/{idDiagnostico}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getDiagnosticoPorId(@PathParam("idDiagnostico") String idDiagnostico);
}
