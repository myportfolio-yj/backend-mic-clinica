package org.veterinaria.aplicacion.puertos.entrada.formulario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cita-formulario")
public interface IFormularioCita {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getFormulario();
}
