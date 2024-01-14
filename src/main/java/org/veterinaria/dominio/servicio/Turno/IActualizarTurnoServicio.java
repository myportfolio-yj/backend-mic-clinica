package org.veterinaria.dominio.servicio.Turno;

import org.veterinaria.dominio.modelo.Turno.TurnoActualizar;
import org.veterinaria.dominio.modelo.Turno.TurnoSalida;

public interface IActualizarTurnoServicio {
  TurnoSalida actualizarTurno(String idTurno, TurnoActualizar turno);
}
