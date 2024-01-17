package org.veterinaria.aplicacion.puertos.entrada.geolocalizacion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/geolocalizacion")
public interface IObtenerGeolocalizacionPorId {
  @GET
  @Path("/{idGeolocalizacion}")
  @Produces(MediaType.APPLICATION_JSON)
  Response getGeolocalizacionPorId(@PathParam("idGeolocalizacion") String idGeolocalizacion);
}
