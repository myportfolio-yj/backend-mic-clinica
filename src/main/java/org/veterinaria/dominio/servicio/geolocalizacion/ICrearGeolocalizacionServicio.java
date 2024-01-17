package org.veterinaria.dominio.servicio.geolocalizacion;

import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionCrear;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;

public interface ICrearGeolocalizacionServicio {
  GeolocalizacionSalida crearGeolocalizacion(GeolocalizacionCrear atencionPeluquero);
}
