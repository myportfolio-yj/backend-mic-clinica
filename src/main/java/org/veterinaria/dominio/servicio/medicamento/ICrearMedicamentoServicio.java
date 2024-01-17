package org.veterinaria.dominio.servicio.medicamento;

import org.veterinaria.dominio.modelo.medicamento.MedicamentoCrear;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

public interface ICrearMedicamentoServicio {
  MedicamentoSalida crearMedicamento(MedicamentoCrear atencionPeluquero);
}
