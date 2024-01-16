package org.veterinaria.aplicacion.puertos.entrada.formulario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cita-formulario")
public interface IFormularioCitaCliente {
  @GET
  @Path("/{idCliente}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getFormularioCliente(@PathParam("idCliente") String idCliente);
}
