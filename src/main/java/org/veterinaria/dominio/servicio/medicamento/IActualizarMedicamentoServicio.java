package org.veterinaria.dominio.servicio.medicamento;

import org.veterinaria.dominio.modelo.medicamento.MedicamentoActualizar;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

public interface IActualizarMedicamentoServicio {
  MedicamentoSalida actualizarMedicamento(String idMedicamento, MedicamentoActualizar medicamento);
}
