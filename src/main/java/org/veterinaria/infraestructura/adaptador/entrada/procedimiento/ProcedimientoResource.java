package org.veterinaria.infraestructura.adaptador.entrada.procedimiento;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.procedimiento.IProcedimientoResource;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoActualizar;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoCrear;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;
import org.veterinaria.dominio.servicio.procedimiento.IProcedimientoServicio;

public class ProcedimientoResource implements IProcedimientoResource {
  private final IProcedimientoServicio servicio;

  @Inject
  public ProcedimientoResource(IProcedimientoServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response postProcedimiento(ProcedimientoCrear procedimientoCrear) {
    ProcedimientoSalida procedimientoSalida = servicio.crearProcedimiento(procedimientoCrear);
    return Response.status(Response.Status.CREATED).entity(procedimientoSalida).build();
  }

  @Override
  public Response putProcedimiento(String idProcedimiento, ProcedimientoActualizar procedimientoActualizar) {
    ProcedimientoSalida procedimientoSalida = servicio.actualizarProcedimiento(idProcedimiento, procedimientoActualizar);
    return Response.ok(procedimientoSalida).build();
  }

  @Override
  public Response deleteProcedimiento(String idProcedimiento) {
    ProcedimientoSalida procedimientoSalida = servicio.eliminarProcedimiento(idProcedimiento);
    return Response.status(Response.Status.CREATED).entity(procedimientoSalida).build();
  }

  @Override
  public Response getProcedimiento() {
    return Response.ok(servicio.obtenerProcedimiento()).build();
  }

  @Override
  public Response getProcedimientoPorId(String idProcedimiento) {
    return Response.ok(servicio.obtenerProcedimientoPorId(idProcedimiento)).build();
  }
}
