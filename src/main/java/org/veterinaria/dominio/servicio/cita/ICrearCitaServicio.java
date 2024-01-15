package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaCrear;
import org.veterinaria.dominio.modelo.cita.CitaSalida;

public interface ICrearCitaServicio {
  CitaSalida crearCita(CitaCrear cita);
}
