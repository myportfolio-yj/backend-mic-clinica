package org.veterinaria.aplicacion.puertos.entrada.Cita;

import org.veterinaria.aplicacion.puertos.entrada.TipoCita.IObtenerTipoCitaPorId;

public interface ICitaResource extends IActualizarCita,
      ICrearCita,
      IEliminarCita,
      IObtenerCita,
      IObtenerCitaPorId {
}
