package org.veterinaria.aplicacion.puertos.salida.procedimiento;

import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoEntidad;

import java.util.List;

public interface IProcedimientoRepositorio {
  List<ProcedimientoEntidad> obtenerTodosProcedimiento();

  ProcedimientoEntidad obtenerProcedimientoPorId(String idProcedimiento);

  ProcedimientoEntidad crearProcedimiento(ProcedimientoEntidad procedimientoEntidad);

  ProcedimientoEntidad actualizarProcedimiento(String idProcedimiento, ProcedimientoEntidad procedimientoEntidad);

  ProcedimientoEntidad eliminarProcedimiento(String idProcedimiento);
}
