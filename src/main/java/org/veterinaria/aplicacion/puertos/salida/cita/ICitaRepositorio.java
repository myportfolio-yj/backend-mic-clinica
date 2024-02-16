package org.veterinaria.aplicacion.puertos.salida.cita;

import org.veterinaria.dominio.modelo.cita.CitaEntidad;

import java.util.List;

public interface ICitaRepositorio {
  List<CitaEntidad> obtenerTodosCita();

  List<CitaEntidad> obtenerTodosCitaAtendidas();

  List<CitaEntidad> obtenerCitasVigentes();

  List<CitaEntidad> obtenerCitasVigentesPorIdCliente(String idCliente);

  CitaEntidad obtenerCitaPorId(String idCita);

  CitaEntidad crearCita(CitaEntidad cita);

  CitaEntidad actualizarCita(String idCita, CitaEntidad cita);

  CitaEntidad eliminarCita(String idCita);
}