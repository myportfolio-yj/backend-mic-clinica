package org.veterinaria.dominio.servicio.turno;

import org.veterinaria.dominio.modelo.turno.TurnoActualizar;
import org.veterinaria.dominio.modelo.turno.TurnoSalida;

public interface IActualizarTurnoServicio {
  TurnoSalida actualizarTurno(String idTurno, TurnoActualizar turno);
}
