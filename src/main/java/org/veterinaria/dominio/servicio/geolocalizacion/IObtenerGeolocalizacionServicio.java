package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

import java.util.List;

public interface IObtenerGeolocalizacionServicio {
  List<GeolocalizacionSalida> obtenerGeolocalizacion();
}
