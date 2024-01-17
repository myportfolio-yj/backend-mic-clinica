package org.veterinaria.aplicacion.puertos.salida.medicamento;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroEntidad;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoEntidad;

import java.util.List;

public interface IMedicamentoRepositorio {
  List<MedicamentoEntidad> obtenerTodosMedicamento();

  MedicamentoEntidad obtenerMedicamentoPorId(String idMedicamento);

  MedicamentoEntidad crearMedicamento(MedicamentoEntidad medicamentoEntidad);

  MedicamentoEntidad actualizarMedicamento(String idMedicamento, MedicamentoEntidad medicamentoEntidad);

  MedicamentoEntidad eliminarMedicamento(String idMedicamento);
}
