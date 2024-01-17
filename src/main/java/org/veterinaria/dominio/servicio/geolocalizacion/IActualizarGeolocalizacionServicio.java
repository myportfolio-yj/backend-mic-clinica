package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionActualizar;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

public interface IActualizarGeolocalizacionServicio {
  GeolocalizacionSalida actualizarGeolocalizacion(String idGeolocalizacion, GeolocalizacionActualizar medicamento);
}
