package org.veterinaria.aplicacion.puertos.entrada.turno;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.turno.TurnoActualizar;

@Path("/turno")
public interface IActualizarTurno {
  @PUT
  @Path("/{idTurno}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putTurno(@PathParam("idTurno") String idTurno, TurnoActualizar turno);
}