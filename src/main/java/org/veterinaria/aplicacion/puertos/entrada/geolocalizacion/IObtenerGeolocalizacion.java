package org.veterinaria.aplicacion.puertos.entrada.geolocalizacion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/geolocalizacion")
public interface IObtenerGeolocalizacion {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Response getGeolocalizacion();
}
