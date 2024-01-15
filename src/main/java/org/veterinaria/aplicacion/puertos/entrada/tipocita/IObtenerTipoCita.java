package org.veterinaria.aplicacion.puertos.entrada.tipocita;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipocita")
public interface IObtenerTipoCita {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getTipoCita();
}
