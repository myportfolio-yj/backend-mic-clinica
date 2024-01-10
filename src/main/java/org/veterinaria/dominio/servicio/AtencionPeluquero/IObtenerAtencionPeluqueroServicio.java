package org.veterinaria.dominio.servicio.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

import java.util.List;

public interface IObtenerAtencionPeluqueroServicio {
  List<AtencionPeluqueroSalida> obtenerAtencionPeluquero();
}
