package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;

public interface ICrearAtencionPeluqueroServicio {
  AtencionPeluqueroSalida crearAtencionPeluquero(AtencionPeluqueroCrear atencionPeluquero);
}
