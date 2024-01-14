package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;

public interface IObtenerAtencionPeluqueroPorIdServicio {
  AtencionPeluqueroSalida obtenerAtencionPeluqueroPorId(String idAtencionPeluquero);
}
