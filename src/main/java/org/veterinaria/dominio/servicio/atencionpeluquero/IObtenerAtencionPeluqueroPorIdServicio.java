package org.veterinaria.dominio.servicio.atencionpeluquero;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

public interface IObtenerAtencionPeluqueroPorIdServicio {
  AtencionPeluqueroSalida obtenerAtencionPeluqueroPorId(String idAtencionPeluquero);
}
