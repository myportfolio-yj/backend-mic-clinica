package org.veterinaria.dominio.servicio.turno;

import org.veterinaria.dominio.modelo.turno.TurnoSalida;

import java.util.List;

public interface IObtenerTurnoServicio {
  List<TurnoSalida> obtenerTurno();
}
