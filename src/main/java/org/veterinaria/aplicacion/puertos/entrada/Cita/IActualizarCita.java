package org.veterinaria.aplicacion.puertos.entrada.Cita;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.Cita.CitaActualizar;

@Path("/cita")
public interface IActualizarCita {
  @PUT
  @Path("/{idCita}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putCita(@PathParam("idCita") String idCita, CitaActualizar cita);
}
