package org.veterinaria.dominio.servicio.tipocita;

import org.veterinaria.dominio.modelo.tipocita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;

public interface IActualizarTipoCitaServicio {
  TipoCitaSalida actualizarTipoCita(String idTipoCita, TipoCitaActualizar tipoCita);
}
