package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaCrear;
import org.veterinaria.dominio.modelo.Cita.CitaSalida;

public interface ICrearCitaServicio {
  CitaSalida crearCita(CitaCrear cita);
}
