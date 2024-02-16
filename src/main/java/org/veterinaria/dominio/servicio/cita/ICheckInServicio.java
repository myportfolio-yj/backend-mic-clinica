package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaSalida;

public interface ICheckInServicio {
  CitaSalida checkIn(String idCita);
}
