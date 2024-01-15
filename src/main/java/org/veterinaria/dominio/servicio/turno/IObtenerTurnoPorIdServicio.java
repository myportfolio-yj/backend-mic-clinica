package org.veterinaria.dominio.servicio.turno;

import org.veterinaria.dominio.modelo.turno.TurnoSalida;

public interface IObtenerTurnoPorIdServicio {
  TurnoSalida obtenerTurnoPorId(String idTurno);
}
