package org.veterinaria.aplicacion.puertos.entrada.diagnostico;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoActualizar;

@Path("/diagnostico")
public interface IActualizarDiagnostico {
  @PUT
  @Path("/{idDiagnostico}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putDiagnostico(@PathParam("idDiagnostico") String idDiagnostico, DiagnosticoActualizar diagnosticoActualizar);
}