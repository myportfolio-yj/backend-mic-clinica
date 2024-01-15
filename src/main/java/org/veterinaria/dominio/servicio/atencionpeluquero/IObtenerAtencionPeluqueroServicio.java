package org.veterinaria.dominio.servicio.atencionpeluquero;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

import java.util.List;

public interface IObtenerAtencionPeluqueroServicio {
  List<AtencionPeluqueroSalida> obtenerAtencionPeluquero();
}
