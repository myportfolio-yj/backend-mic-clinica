package org.veterinaria.aplicacion.puertos.entrada.geolocalizacion;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionActualizar;

@Path("/geolocalizacion")
public interface IActualizarGeolocalizacion {
  @PUT
  @Path("/{idGeolocalizacion}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putGeolocalizacion(@PathParam("idGeolocalizacion") String idGeolocalizacion, GeolocalizacionActualizar geolocalizacionActualizar);
}