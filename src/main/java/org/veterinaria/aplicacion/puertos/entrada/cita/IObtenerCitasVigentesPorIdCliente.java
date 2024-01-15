package org.veterinaria.aplicacion.puertos.entrada.cita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cita-vigentes")
public interface IObtenerCitasVigentesPorIdCliente {
  @GET
  @Path("/{idCliente}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getCitaVigentesPorIdCliente(@PathParam("idCliente") String idCliente);
}
