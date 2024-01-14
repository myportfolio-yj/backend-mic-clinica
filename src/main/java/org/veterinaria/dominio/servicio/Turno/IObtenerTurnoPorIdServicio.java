package org.veterinaria.dominio.servicio.Turno;

import org.veterinaria.dominio.modelo.Turno.TurnoSalida;

public interface IObtenerTurnoPorIdServicio {
  TurnoSalida obtenerTurnoPorId(String idTurno);
}
