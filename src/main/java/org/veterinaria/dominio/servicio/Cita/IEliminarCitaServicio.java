package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaSalida;

public interface IEliminarCitaServicio {
  CitaSalida eliminarCita(String idCita);
}
