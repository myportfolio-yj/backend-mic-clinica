package org.veterinaria.infraestructura.adaptador.entrada.geolocalizacion;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.geolocalizacion.IGeolocalizacionResource;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionActualizar;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionCrear;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;
import org.veterinaria.dominio.servicio.geolocalizacion.IGeolocalizacionServicio;

public class GeolocalizacionResource implements IGeolocalizacionResource {
  @Inject
  IGeolocalizacionServicio servicio;

  @Override
  public Response getGeolocalizacion() {
    return Response.ok(servicio.obtenerGeolocalizacion()).build();
  }

  @Override
  public Response getGeolocalizacionPorId(String idGeolocalizacion) {
    return Response.ok(servicio.obtenerGeolocalizacionPorId(idGeolocalizacion)).build();
  }

  @Override
  public Response postGeolocalizacion(GeolocalizacionCrear geolocalizacionCrear) {
    GeolocalizacionSalida geolocalizacionSalida = servicio.crearGeolocalizacion(geolocalizacionCrear);
    return Response.status(Response.Status.CREATED).entity(geolocalizacionSalida).build();
  }

  @Override
  public Response putGeolocalizacion(String idGeolocalizacion, GeolocalizacionActualizar geolocalizacionActualizar) {
    GeolocalizacionSalida geolocalizacionSalida = servicio.actualizarGeolocalizacion(idGeolocalizacion, geolocalizacionActualizar);
    return Response.ok(geolocalizacionSalida).build();
  }

  @Override
  public Response deleteGeolocalizacion(String idGeolocalizacion) {
    GeolocalizacionSalida geolocalizacionSalida = servicio.eliminarGeolocalizacion(idGeolocalizacion);
    return Response.status(Response.Status.CREATED).entity(geolocalizacionSalida).build();
  }
}
