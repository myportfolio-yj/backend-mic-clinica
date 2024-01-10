package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaActualizar;
import org.veterinaria.dominio.modelo.Cita.CitaSalida;

public interface IActualizarCitaServicio {
  CitaSalida actualizarCita(String idCita, CitaActualizar cita);
}
