package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

public interface IObtenerGeolocalizacionPorIdServicio {
  GeolocalizacionSalida obtenerGeolocalizacionPorId(String idGeolocalizacion);
}
