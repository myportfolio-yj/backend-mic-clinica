package org.veterinaria.dominio.servicio.Cita;

import org.veterinaria.dominio.modelo.Cita.CitaSalida;

import java.util.List;

public interface IObtenerCitaVigentesPorIdClienteServicio {
  List<CitaSalida> obtenerCitasVigentesPorIdCliente(String idCliente);
}
