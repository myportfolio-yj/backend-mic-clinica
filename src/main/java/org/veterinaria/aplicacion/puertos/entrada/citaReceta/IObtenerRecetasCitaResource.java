package org.veterinaria.aplicacion.puertos.entrada.citaReceta;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cita-recetas")
public interface IObtenerRecetasCitaResource {
  @GET
  @Path("/{idCita}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getRecetaPorIdCita(@PathParam("idCita") String idCita);
}
