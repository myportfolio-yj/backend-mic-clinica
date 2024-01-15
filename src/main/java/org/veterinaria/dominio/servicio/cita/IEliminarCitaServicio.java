package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaSalida;

public interface IEliminarCitaServicio {
  CitaSalida eliminarCita(String idCita);
}
