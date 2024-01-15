package org.veterinaria.dominio.servicio.atencionpeluquero;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

public interface ICrearAtencionPeluqueroServicio {
  AtencionPeluqueroSalida crearAtencionPeluquero(AtencionPeluqueroCrear atencionPeluquero);
}
