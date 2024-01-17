package org.veterinaria.infraestructura.adaptador.salida.medicamento;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.cita.ICitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.medicamento.IMedicamentoRepositorio;
import org.veterinaria.dominio.modelo.cita.CitaEntidad;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoEntidad;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MedicamentoRepositorio implements PanacheMongoRepository<MedicamentoEntidad>, IMedicamentoRepositorio {
  @Override
  public List<MedicamentoEntidad> obtenerTodosMedicamento() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public MedicamentoEntidad obtenerMedicamentoPorId(String idMedicamento) {
    return findEntidadById(idMedicamento)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(MedicamentoEntidad::new);
  }

  @Override
  public MedicamentoEntidad crearMedicamento(MedicamentoEntidad medicamento) {
    medicamento.setBorrado(false);
    medicamento.persist();
    return medicamento;
  }

  @Override
  public MedicamentoEntidad actualizarMedicamento(String idMedicamento, MedicamentoEntidad medicamento) {
    return findEntidadById(idMedicamento)
          .map(p -> {
            p.setMedicamento(medicamento.getMedicamento());
            p.setDescripcion(medicamento.getDescripcion());
            p.setBorrado(medicamento.getBorrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Cita no encontrado"));
  }

  @Override
  public MedicamentoEntidad eliminarMedicamento(String idMedicamento) {
    MedicamentoEntidad medicamento = this.obtenerMedicamentoPorId(idMedicamento);
    medicamento.setBorrado(true);
    return this.actualizarMedicamento(idMedicamento, medicamento);
  }

  private Optional<MedicamentoEntidad> findEntidadById(String idMedicamento) {
    return findByIdOptional(new ObjectId(idMedicamento));
  }
}
