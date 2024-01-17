package org.veterinaria.aplicacion.puertos.entrada.procedimiento;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/procedimiento")
public interface IEliminarProcedimiento {
  @DELETE
  @Path("/{idProcedimiento}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteProcedimiento(@PathParam("idProcedimiento") String idProcedimiento);
}
