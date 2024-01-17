package org.veterinaria.dominio.servicio.medicamento;

import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

public interface IEliminarMedicamentoServicio {
  MedicamentoSalida eliminarMedicamento(String idMedicamento);
}
