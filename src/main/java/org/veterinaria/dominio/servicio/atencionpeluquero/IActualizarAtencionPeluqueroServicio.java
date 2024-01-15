package org.veterinaria.dominio.servicio.atencionpeluquero;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

public interface IActualizarAtencionPeluqueroServicio {
  AtencionPeluqueroSalida actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluquero);
}
