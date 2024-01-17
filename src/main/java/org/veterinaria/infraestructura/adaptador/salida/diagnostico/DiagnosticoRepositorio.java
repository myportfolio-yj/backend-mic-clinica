package org.veterinaria.infraestructura.adaptador.salida.diagnostico;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.diagnostico.IDiagnosticoRepositorio;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DiagnosticoRepositorio implements PanacheMongoRepository<DiagnosticoEntidad>, IDiagnosticoRepositorio {
  @Override
  public List<DiagnosticoEntidad> obtenerTodosDiagnostico() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public DiagnosticoEntidad obtenerDiagnosticoPorId(String idDiagnostico) {
    return findEntidadById(idDiagnostico)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(DiagnosticoEntidad::new);
  }

  @Override
  public DiagnosticoEntidad crearDiagnostico(DiagnosticoEntidad diagnostico) {
    diagnostico.setBorrado(false);
    diagnostico.persist();
    return diagnostico;
  }

  @Override
  public DiagnosticoEntidad actualizarDiagnostico(String idDiagnostico, DiagnosticoEntidad diagnostico) {
    return findEntidadById(idDiagnostico)
          .map(p -> {
            p.setDiagnostico(diagnostico.getDiagnostico());
            p.setDetalle(diagnostico.getDetalle());
            p.setBorrado(diagnostico.getBorrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Diagnostico no encontrado"));
  }

  @Override
  public DiagnosticoEntidad eliminarDiagnostico(String idDiagnostico) {
    DiagnosticoEntidad diagnostico = this.obtenerDiagnosticoPorId(idDiagnostico);
    diagnostico.setBorrado(true);
    return this.actualizarDiagnostico(idDiagnostico, diagnostico);
  }

  private Optional<DiagnosticoEntidad> findEntidadById(String idMedicamento) {
    return findByIdOptional(new ObjectId(idMedicamento));
  }
}
