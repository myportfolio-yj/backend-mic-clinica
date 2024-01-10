package org.veterinaria.dominio.servicio.TipoCita;

import org.veterinaria.dominio.modelo.TipoCita.TipoCitaActualizar;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface IActualizarTipoCitaServicio {
  TipoCitaSalida actualizarTipoCita(String idTipoCita, TipoCitaActualizar tipoCita);
}
