package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

public interface IEliminarGeolocalizacionServicio {
  GeolocalizacionSalida eliminarGeolocalizacion(String idGeolocalizacion);
}
