package org.veterinaria.dominio.servicio.TipoCita;

import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

import java.util.List;

public interface IObtenerTipoCitaServicio {
  List<TipoCitaSalida> obtenerTipoCita();
}
