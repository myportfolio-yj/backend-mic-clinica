package org.veterinaria.aplicacion.puertos.entrada.Turno;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Turno.TurnoActualizar;

@Path("/turno")
public interface IActualizarTurno {
  @PUT
  @Path("/{idTurno}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putTurno(@PathParam("idTurno") String idTurno, TurnoActualizar turno);
}