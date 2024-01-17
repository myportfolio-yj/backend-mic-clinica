package org.veterinaria.aplicacion.puertos.entrada.diagnostico;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/diagnostico")
public interface IEliminarDiagnostico {
  @DELETE
  @Path("/{idDiagnostico}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteDiagnostico(@PathParam("idDiagnostico") String idDiagnostico);
}
