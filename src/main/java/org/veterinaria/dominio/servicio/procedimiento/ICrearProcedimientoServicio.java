package org.veterinaria.dominio.servicio.procedimiento;

import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoCrear;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;

public interface ICrearProcedimientoServicio {
  ProcedimientoSalida crearProcedimiento(ProcedimientoCrear procedimientoCrear);
}
