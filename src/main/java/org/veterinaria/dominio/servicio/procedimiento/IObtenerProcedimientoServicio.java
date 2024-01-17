package org.veterinaria.dominio.servicio.procedimiento;

import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoSalida;

import java.util.List;

public interface IObtenerProcedimientoServicio {
  List<ProcedimientoSalida> obtenerProcedimiento();
}
