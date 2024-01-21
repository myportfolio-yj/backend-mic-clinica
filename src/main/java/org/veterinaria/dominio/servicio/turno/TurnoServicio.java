package org.veterinaria.dominio.servicio.turno;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.tipocita.ITipoCitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.turno.ITurnoRepositorio;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaEntidad;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;
import org.veterinaria.dominio.modelo.turno.TurnoActualizar;
import org.veterinaria.dominio.modelo.turno.TurnoCrear;
import org.veterinaria.dominio.modelo.turno.TurnoEntidad;
import org.veterinaria.dominio.modelo.turno.TurnoSalida;

import java.util.List;

@ApplicationScoped
public class TurnoServicio implements ITurnoServicio {
  private final ITurnoRepositorio repositorio;
  private final ITipoCitaRepositorio repositorioTipoCita;

  @Inject
  public TurnoServicio(ITurnoRepositorio repositorio, ITipoCitaRepositorio repositorioTipoCita) {
    this.repositorio = repositorio;
    this.repositorioTipoCita = repositorioTipoCita;
  }

  @Override
  public TurnoSalida obtenerTurnoPorId(String idTipoCita) {
    TurnoEntidad turnoEntidad = repositorio.obtenerTurnoPorId(idTipoCita);
    TipoCitaEntidad citaEntidad = repositorioTipoCita.obtenerTipoCitaPorId(turnoEntidad.getIdTipoCita());
    return TurnoSalida.builder()
          .id(turnoEntidad.id.toString())
          .tipoCita(
                TipoCitaSalida.builder()
                      .id(citaEntidad.id.toString())
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
    return this.obtenerTurnoPorId(turnoEntidad.id.toString());
  }

  @Override
  public TurnoSalida eliminarTurno(String idTurno) {
    TurnoEntidad turnoEntidad = repositorio.eliminarTurno(idTurno);
    TipoCitaEntidad citaEntidad = repositorioTipoCita.obtenerTipoCitaPorId(turnoEntidad.getIdTipoCita());
    return TurnoSalida.builder()
          .id(turnoEntidad.id.toString())
          .tipoCita(
                TipoCitaSalida.builder()
                      .id(citaEntidad.id.toString())
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
                  .id(p.id.toString())
                  .tipoCita(
                        TipoCitaSalida.builder()
                              .id(citaEntidad.id.toString())
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
