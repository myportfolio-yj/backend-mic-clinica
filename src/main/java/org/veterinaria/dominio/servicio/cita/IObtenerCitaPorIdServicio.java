package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaSalida;

public interface IObtenerCitaPorIdServicio {
  CitaSalida obtenerCitaPorId(String idCita);
}
