package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaSalida;

public interface IObtenerCitaPorIdServicio {
  CitaSalida obtenerCitaPorId(String idCita);
}
