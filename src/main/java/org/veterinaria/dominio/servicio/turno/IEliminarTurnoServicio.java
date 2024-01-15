package org.veterinaria.dominio.servicio.turno;

import org.veterinaria.dominio.modelo.turno.TurnoSalida;

public interface IEliminarTurnoServicio {
  TurnoSalida eliminarTurno(String idTurno);
}
