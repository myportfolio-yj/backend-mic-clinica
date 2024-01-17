package org.veterinaria.dominio.servicio.procedimiento;

import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;

public interface IEliminarProcedimientoServicio {
  ProcedimientoSalida eliminarProcedimiento(String idProcedimiento);
}
