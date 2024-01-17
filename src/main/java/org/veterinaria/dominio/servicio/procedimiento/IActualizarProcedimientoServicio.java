package org.veterinaria.dominio.servicio.procedimiento;

import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoActualizar;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;

public interface IActualizarProcedimientoServicio {
  ProcedimientoSalida actualizarProcedimiento(String idProcedimiento, ProcedimientoActualizar procedimiento);
}
