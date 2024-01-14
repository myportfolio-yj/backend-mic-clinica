package org.veterinaria.aplicacion.puertos.salida.Turno;

import org.veterinaria.dominio.modelo.Turno.TurnoEntidad;

import java.util.List;

public interface ITurnoRepositorio {
  List<TurnoEntidad> obtenerTodosTurno();

  TurnoEntidad obtenerTurnoPorId(String idTurno);

  TurnoEntidad crearTurno(TurnoEntidad turno);

  TurnoEntidad actualizarTurno(String idTurno, TurnoEntidad turno);

  TurnoEntidad eliminarTurno(String idTurno);
}
