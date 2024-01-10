package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface IEliminarCitaServicio {
  CitaSalida eliminarCita(String idCita);
}
