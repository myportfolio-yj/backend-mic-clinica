package org.veterinaria.dominio.servicio.cita;

import org.veterinaria.dominio.modelo.cita.CitaSalida;

import java.util.List;

public interface IObtenerCitaServicio {
  List<CitaSalida> obtenerCita();
}
