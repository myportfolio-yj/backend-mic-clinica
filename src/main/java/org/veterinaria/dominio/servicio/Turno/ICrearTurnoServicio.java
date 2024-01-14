package org.veterinaria.dominio.servicio.Turno;

import org.veterinaria.dominio.modelo.Turno.TurnoCrear;
import org.veterinaria.dominio.modelo.Turno.TurnoSalida;

public interface ICrearTurnoServicio {
  TurnoSalida crearTurno(TurnoCrear turno);
}
