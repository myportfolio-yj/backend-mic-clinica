package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface IEliminarAtencionPeluqueroServicio {
  AtencionPeluqueroSalida eliminarAtencionPeluquero(String idAtencionPeluquero);
}
