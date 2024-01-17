package org.veterinaria.dominio.servicio.medicamento;

import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

import java.util.List;

public interface IObtenerMedicamentoServicio {
  List<MedicamentoSalida> obtenerMedicamento();
}
