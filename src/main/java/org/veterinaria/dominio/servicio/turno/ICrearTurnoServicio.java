package org.veterinaria.dominio.servicio.turno;

import org.veterinaria.dominio.modelo.turno.TurnoCrear;
import org.veterinaria.dominio.modelo.turno.TurnoSalida;

public interface ICrearTurnoServicio {
  TurnoSalida crearTurno(TurnoCrear turno);
}
