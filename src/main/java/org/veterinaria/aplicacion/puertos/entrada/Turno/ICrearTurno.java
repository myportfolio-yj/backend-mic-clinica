package org.veterinaria.aplicacion.puertos.entrada.Turno;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Turno.TurnoCrear;

@Path("/turno")
public interface ICrearTurno {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postTurno(TurnoCrear turno);
}
