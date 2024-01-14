package org.veterinaria.dominio.servicio.Turno;

import org.veterinaria.dominio.modelo.Turno.TurnoSalida;

import java.util.List;

public interface IObtenerTurnoServicio {
  List<TurnoSalida> obtenerTurno();
}
