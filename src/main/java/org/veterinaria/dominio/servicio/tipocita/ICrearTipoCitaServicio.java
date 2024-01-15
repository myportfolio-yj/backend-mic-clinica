package org.veterinaria.dominio.servicio.tipocita;

import org.veterinaria.dominio.modelo.tipocita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;

public interface ICrearTipoCitaServicio {
  TipoCitaSalida crearTipoCita(TipoCitaCrear tipoCita);
}
