package org.veterinaria.infraestructura.adaptador.entrada.geolocalizacion;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.geolocalizacion.IGeolocalizacionMascotaResource;
import org.veterinaria.dominio.servicio.geolocalizacion.IGeolocalizacionServicio;

public class GeolocalizacionMascotaResource implements IGeolocalizacionMascotaResource {
  @Inject
  IGeolocalizacionServicio servicio;

  @Override
  public Response getGeolocalizacionPorIdMascota(String idMascota) {
    return Response.ok(servicio.obtenerGeolocalizacionPorIdMascota(idMascota)).build();
  }

}
