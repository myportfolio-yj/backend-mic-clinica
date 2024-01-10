package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaCrear;
import org.veterinaria.dominio.modelo.Cita.CitaSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;

public interface ICrearCitaServicio {
  CitaSalida crearCita(CitaCrear cita);
}
