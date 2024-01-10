package org.veterinaria.dominio.servicio.TipoCita;

import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface IObtenerTipoCitaPorIdServicio {
  TipoCitaSalida obtenerTipoCitaPorId(String idTipoCita);
}
