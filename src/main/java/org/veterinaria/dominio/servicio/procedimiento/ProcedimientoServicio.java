package org.veterinaria.dominio.servicio.procedimiento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.procedimiento.IProcedimientoRepositorio;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoActualizar;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoCrear;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoEntidad;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;

import java.util.List;

@ApplicationScoped
public class ProcedimientoServicio implements IProcedimientoServicio {
  private final IProcedimientoRepositorio repositorio;

  @Inject
  public ProcedimientoServicio(IProcedimientoRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public List<ProcedimientoSalida> obtenerProcedimiento() {
    List<ProcedimientoEntidad> procedimientoEntidades = repositorio.obtenerTodosProcedimiento();
    return procedimientoEntidades.parallelStream().map(p -> ProcedimientoSalida.builder()
                .id(p.id.toString())
                .procedimiento(p.getProcedimiento())
                .descripcion(p.getDescripcion())
                .build())
          .toList();
  }

  @Override
  public ProcedimientoSalida obtenerProcedimientoPorId(String idProcedimiento) {
    ProcedimientoEntidad procedimientoEntidades = repositorio.obtenerProcedimientoPorId(idProcedimiento);
    return ProcedimientoSalida.builder()
          .id(procedimientoEntidades.id.toString())
          .procedimiento(procedimientoEntidades.getProcedimiento())
          .descripcion(procedimientoEntidades.getDescripcion())
          .build();
  }

  @Override
  public ProcedimientoSalida crearProcedimiento(ProcedimientoCrear procedimientoCrear) {
    ProcedimientoEntidad procedimientoEntidad = new ProcedimientoEntidad();
    procedimientoEntidad.setProcedimiento(procedimientoCrear.getProcedimiento());
    procedimientoEntidad.setDescripcion(procedimientoCrear.getDescripcion());
    procedimientoEntidad = repositorio.crearProcedimiento(procedimientoEntidad);
    return this.obtenerProcedimientoPorId(procedimientoEntidad.id.toString());
  }

  @Override
  public ProcedimientoSalida actualizarProcedimiento(String idProcedimiento, ProcedimientoActualizar procedimientoActualizar) {
    ProcedimientoEntidad procedimientoEntidad = new ProcedimientoEntidad();
    procedimientoEntidad.setProcedimiento(procedimientoActualizar.getProcedimiento());
    procedimientoEntidad.setDescripcion(procedimientoActualizar.getDescripcion());
    repositorio.actualizarProcedimiento(idProcedimiento, procedimientoEntidad);
    return this.obtenerProcedimientoPorId(idProcedimiento);
  }

  @Override
  public ProcedimientoSalida eliminarProcedimiento(String idProcedimiento) {
    ProcedimientoEntidad procedimientoEntidad = repositorio.eliminarProcedimiento(idProcedimiento);
    return ProcedimientoSalida.builder()
          .id(procedimientoEntidad.id.toString())
          .procedimiento(procedimientoEntidad.getProcedimiento())
          .descripcion(procedimientoEntidad.getDescripcion())
          .build();
  }
}
