package org.veterinaria.aplicacion.puertos.entrada.medicamento;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/medicamento")
public interface IObtenerMedicamentoPorId {
  @GET
  @Path("/{idMedicamento}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getMedicamentoPorId(@PathParam("idMedicamento") String idMedicamento);
}
