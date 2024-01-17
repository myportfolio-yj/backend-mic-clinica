package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

import java.util.List;

public interface IObtenerGeolocalizacionPorIdMascotaServicio {
  List<GeolocalizacionSalida> obtenerGeolocalizacionPorIdMascota(String idMascota);
}
