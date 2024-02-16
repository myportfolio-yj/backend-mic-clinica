package org.veterinaria.aplicacion.puertos.entrada.checkin;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/veterinaria/checkin")
public interface ICheckInVeterinariaResource {
  @POST
  @Path("/{idCita}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response checkInVeterinaria(@PathParam("idCita") String idCita);
}
