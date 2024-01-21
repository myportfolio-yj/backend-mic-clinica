package org.veterinaria.aplicacion.puertos.salida.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionEntidad;

import java.util.List;

public interface IGeolocalizacionRepositorio {
  List<GeolocalizacionEntidad> obtenerTodosGeolocalizacion();

  GeolocalizacionEntidad obtenerGeolocalizacionPorId(String idGeolocalizacion);

  List<GeolocalizacionEntidad> obtenerGeolocalizacionPorIdMascota(String idMascota);

  GeolocalizacionEntidad crearGeolocalizacion(GeolocalizacionEntidad geolocalizacionEntidad);

  GeolocalizacionEntidad actualizarGeolocalizacion(String idGeolocalizacion, GeolocalizacionEntidad geolocalizacionEntidad);

  GeolocalizacionEntidad eliminarGeolocalizacion(String idGeolocalizacion);
}
