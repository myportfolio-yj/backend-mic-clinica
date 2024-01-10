package org.veterinaria.aplicacion.puertos.entrada.Cita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/cita")
public interface IObtenerCitaPorId {
  @GET
  @Path("/{idCita}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getCitaPorId(@PathParam("idCita") String idCita);
}
