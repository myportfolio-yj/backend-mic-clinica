package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaActualizar;
import org.veterinaria.dominio.modelo.cita.CitaSalida;

public interface IActualizarCitaServicio {
  CitaSalida actualizarCita(String idCita, CitaActualizar cita);
}
