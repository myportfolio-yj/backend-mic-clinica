package org.veterinaria.aplicacion.puertos.entrada.geolocalizacion;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/geolocalizacion")
public interface IEliminarGeolocalizacion {
  @DELETE
  @Path("/{idGeolocalizacion}")
  @Produces(MediaType.APPLICATION_JSON)
  Response deleteGeolocalizacion(@PathParam("idGeolocalizacion") String idGeolocalizacion);
}
