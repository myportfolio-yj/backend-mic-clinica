package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface IActualizarAtencionPeluqueroServicio {
  AtencionPeluqueroSalida actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluquero);
}
