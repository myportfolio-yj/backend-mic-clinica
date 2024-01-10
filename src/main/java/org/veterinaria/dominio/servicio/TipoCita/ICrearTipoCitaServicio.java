package org.veterinaria.dominio.servicio.TipoCita;

import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface ICrearTipoCitaServicio {
  TipoCitaSalida crearTipoCita(TipoCitaCrear TipoCita);
}
