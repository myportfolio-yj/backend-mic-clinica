package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaSalida;

import java.util.List;

public interface IObtenerCitaVigentesServicio {
  List<CitaSalida> obtenerCitasVigentes();
}
