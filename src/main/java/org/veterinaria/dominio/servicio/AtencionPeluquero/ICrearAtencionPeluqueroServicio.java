package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface ICrearAtencionPeluqueroServicio {
  AtencionPeluqueroSalida crearAtencionPeluquero(AtencionPeluqueroCrear atencionPeluquero);
}
