package org.veterinaria.dominio.servicio.tipocita;

import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;

import java.util.List;

public interface IObtenerTipoCitaServicio {
  List<TipoCitaSalida> obtenerTipoCita();
}
