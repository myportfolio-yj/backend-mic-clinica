package org.veterinaria.dominio.servicio.Turno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.TipoCita.ITipoCitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.Turno.ITurnoRepositorio;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;
import org.veterinaria.dominio.modelo.Turno.TurnoActualizar;
import org.veterinaria.dominio.modelo.Turno.TurnoCrear;
import org.veterinaria.dominio.modelo.Turno.TurnoEntidad;
import org.veterinaria.dominio.modelo.Turno.TurnoSalida;
import org.veterinaria.dominio.servicio.TipoCita.ITipoCitaServicio;

import java.util.List;

@ApplicationScoped
public class TurnoServicio implements ITurnoServicio {
  @Inject
  ITurnoRepositorio repositorio;
  @Inject
  ITipoCitaRepositorio repositorioTipoCita;

  @Override
  public TurnoSalida obtenerTurnoPorId(String idTipoCita) {
    TurnoEntidad turnoEntidad = repositorio.obtenerTurnoPorId(idTipoCita);
    TipoCitaEntidad citaEntidad = repositorioTipoCita.obtenerTipoCitaPorId(turnoEntidad.getIdTipoCita());
    return TurnoSalida.builder()
          .id(turnoEntidad.getId().toString())
          .tipoCita(
                TipoCitaSalida.builder()
                      .id(citaEntidad.getId().toString())
                      .tipoCita(citaEntidad.getTipoCita())
                      .build()
          )
          .turno(turnoEntidad.getTurno())
          .valor(turnoEntidad.getValor())
          .diaSemana(turnoEntidad.getDiaSemana())
          .build();
  }

  @Override
  public TurnoSalida actualizarTurno(String idTipoCita, TurnoActualizar turno) {
    TurnoEntidad turnoEntidad = new TurnoEntidad();
    turnoEntidad.setIdTipoCita(turno.getIdTipoCita());
    turnoEntidad.setDiaSemana(turno.getDiaSemana());
    turnoEntidad.setTurno(turno.getTurno());
    turnoEntidad.setValor(turno.getValor());
    repositorio.actualizarTurno(idTipoCita, turnoEntidad);
    return this.obtenerTurnoPorId(idTipoCita);
  }

  @Override
  public TurnoSalida crearTurno(TurnoCrear turno) {
    TurnoEntidad turnoEntidad = new TurnoEntidad();
    turnoEntidad.setIdTipoCita(turno.getIdTipoCita());
    turnoEntidad.setDiaSemana(turno.getDiaSemana());
    turnoEntidad.setTurno(turno.getTurno());
    turnoEntidad.setValor(turno.getValor());
    turnoEntidad = repositorio.crearTurno(turnoEntidad);
    return this.obtenerTurnoPorId(turnoEntidad.getId().toString());
  }

  @Override
  public TurnoSalida eliminarTurno(String idTurno) {
    TurnoEntidad turnoEntidad = repositorio.eliminarTurno(idTurno);
    TipoCitaEntidad citaEntidad = repositorioTipoCita.obtenerTipoCitaPorId(turnoEntidad.getIdTipoCita());
    return TurnoSalida.builder()
          .id(turnoEntidad.getId().toString())
          .tipoCita(
                TipoCitaSalida.builder()
                      .id(citaEntidad.getId().toString())
                      .tipoCita(citaEntidad.getTipoCita())
                      .build()
          )
          .turno(turnoEntidad.getTurno())
          .valor(turnoEntidad.getValor())
          .diaSemana(turnoEntidad.getDiaSemana())
          .build();
  }

  @Override
  public List<TurnoSalida> obtenerTurno() {
    List<TurnoEntidad> turnos = repositorio.obtenerTodosTurno();
    return turnos.parallelStream().map(p -> {
            TipoCitaEntidad citaEntidad = repositorioTipoCita.obtenerTipoCitaPorId(p.getIdTipoCita());
            return TurnoSalida.builder()
                  .id(p.getId().toString())
                  .tipoCita(
                        TipoCitaSalida.builder()
                              .id(citaEntidad.getId().toString())
                              .tipoCita(citaEntidad.getTipoCita())
                              .build()
                  )
                  .turno(p.getTurno())
                  .valor(p.getValor())
                  .diaSemana(p.getDiaSemana())
                  .build();
          })
          .toList();
  }
}
