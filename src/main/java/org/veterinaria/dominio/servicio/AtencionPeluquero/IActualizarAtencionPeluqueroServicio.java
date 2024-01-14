package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;

public interface IActualizarAtencionPeluqueroServicio {
  AtencionPeluqueroSalida actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluquero);
}
