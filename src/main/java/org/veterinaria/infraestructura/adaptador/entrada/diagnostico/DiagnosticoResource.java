package org.veterinaria.infraestructura.adaptador.entrada.diagnostico;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.diagnostico.IDiagnosticoResource;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoActualizar;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoCrear;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;
import org.veterinaria.dominio.servicio.diagnostico.IDiagnosticoServicio;

public class DiagnosticoResource implements IDiagnosticoResource {
  @Inject
  IDiagnosticoServicio servicio;

  @Override
  public Response postDiagnostico(DiagnosticoCrear diagnosticoCrear) {
    DiagnosticoSalida diagnosticoSalida = servicio.crearDiagnostico(diagnosticoCrear);
    return Response.status(Response.Status.CREATED).entity(diagnosticoSalida).build();
  }

  @Override
  public Response putDiagnostico(String idDiagnostico, DiagnosticoActualizar diagnosticoActualizar) {
    DiagnosticoSalida diagnosticoSalida = servicio.actualizarDiagnostico(idDiagnostico, diagnosticoActualizar);
    return Response.ok(diagnosticoSalida).build();
  }

  @Override
  public Response deleteDiagnostico(String idDiagnostico) {
    DiagnosticoSalida diagnosticoSalida = servicio.eliminarDiagnostico(idDiagnostico);
    return Response.status(Response.Status.CREATED).entity(diagnosticoSalida).build();
  }

  @Override
  public Response getDiagnostico() {
    return Response.ok(servicio.obtenerDiagnostico()).build();
  }

  @Override
  public Response getDiagnosticoPorId(String idDiagnostico) {
    return Response.ok(servicio.obtenerDiagnosticoPorId(idDiagnostico)).build();
  }
}
