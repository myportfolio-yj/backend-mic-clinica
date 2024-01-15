package org.veterinaria.infraestructura.adaptador.entrada.turno;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.turno.ITurnoResource;
import org.veterinaria.dominio.modelo.turno.TurnoActualizar;
import org.veterinaria.dominio.modelo.turno.TurnoCrear;
import org.veterinaria.dominio.modelo.turno.TurnoSalida;
import org.veterinaria.dominio.servicio.turno.ITurnoServicio;

public class TurnoResource implements ITurnoResource {
  @Inject
  ITurnoServicio servicio;

  @Override
  public Response putTurno(String idTurno, TurnoActualizar turno) {
    TurnoSalida turnoSalida = servicio.actualizarTurno(idTurno, turno);
    return Response.ok(turnoSalida).build();
  }

  @Override
  public Response postTurno(TurnoCrear turno) {
    TurnoSalida turnoSalida = servicio.crearTurno(turno);
    return Response.status(Response.Status.CREATED).entity(turnoSalida).build();
  }

  @Override
  public Response deleteTurno(String idTurno) {
    TurnoSalida turnoSalida = servicio.eliminarTurno(idTurno);
    return Response.status(Response.Status.CREATED).entity(turnoSalida).build();
  }

  @Override
  public Response getTurno() {
    return Response.ok(servicio.obtenerTurno()).build();
  }

  @Override
  public Response getTurnoPorId(String idTurno) {
    return Response.ok(servicio.obtenerTurnoPorId(idTurno)).build();
  }
}
