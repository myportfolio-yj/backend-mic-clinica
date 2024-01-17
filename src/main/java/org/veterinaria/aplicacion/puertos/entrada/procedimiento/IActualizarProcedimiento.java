package org.veterinaria.aplicacion.puertos.entrada.procedimiento;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoActualizar;

@Path("/procedimiento")
public interface IActualizarProcedimiento {
  @PUT
  @Path("/{idProcedimiento}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putProcedimiento(@PathParam("idProcedimiento") String idProcedimiento, ProcedimientoActualizar procedimientoActualizar);
}