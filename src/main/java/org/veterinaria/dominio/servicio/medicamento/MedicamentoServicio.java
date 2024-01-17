package org.veterinaria.dominio.servicio.medicamento;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.medicamento.IMedicamentoRepositorio;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoActualizar;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoCrear;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoEntidad;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

import java.util.List;

@ApplicationScoped
public class MedicamentoServicio implements IMedicamentoServicio {
  @Inject
  IMedicamentoRepositorio repositorio;

  @Override
  public List<MedicamentoSalida> obtenerMedicamento() {
    List<MedicamentoEntidad> medicamentoEntidades = repositorio.obtenerTodosMedicamento();
    return medicamentoEntidades.parallelStream().map(p -> MedicamentoSalida.builder()
                .id(p.id.toString())
                .medicamento(p.getMedicamento())
                .descripcion(p.getDescripcion())
                .build())
          .toList();
  }

  @Override
  public MedicamentoSalida obtenerMedicamentoPorId(String idMedicamento) {
    MedicamentoEntidad medicamentoEntidades = repositorio.obtenerMedicamentoPorId(idMedicamento);
    return MedicamentoSalida.builder()
          .id(medicamentoEntidades.id.toString())
          .medicamento(medicamentoEntidades.getMedicamento())
          .descripcion(medicamentoEntidades.getDescripcion())
          .build();
  }

  @Override
  public MedicamentoSalida crearMedicamento(MedicamentoCrear medicamentoCrear) {
    MedicamentoEntidad medicamentoEntidad = new MedicamentoEntidad();
    medicamentoEntidad.setMedicamento(medicamentoCrear.getMedicamento());
    medicamentoEntidad.setDescripcion(medicamentoCrear.getDescripcion());
    medicamentoEntidad = repositorio.crearMedicamento(medicamentoEntidad);
    return this.obtenerMedicamentoPorId(medicamentoEntidad.id.toString());
  }
  @Override
  public MedicamentoSalida actualizarMedicamento(String idMedicamento, MedicamentoActualizar medicamentoActualizar) {
    MedicamentoEntidad medicamentoEntidad = new MedicamentoEntidad();
    medicamentoEntidad.setMedicamento(medicamentoActualizar.getMedicamento());
    medicamentoEntidad.setDescripcion(medicamentoActualizar.getDescripcion());
    repositorio.actualizarMedicamento(idMedicamento, medicamentoEntidad);
    return this.obtenerMedicamentoPorId(idMedicamento);
  }

  @Override
  public MedicamentoSalida eliminarMedicamento(String idMedicamento) {
    MedicamentoEntidad medicamentoEntidad = repositorio.eliminarMedicamento(idMedicamento);
    return MedicamentoSalida.builder()
          .id(medicamentoEntidad.id.toString())
          .medicamento(medicamentoEntidad.getMedicamento())
          .descripcion(medicamentoEntidad.getDescripcion())
          .build();
  }
}
