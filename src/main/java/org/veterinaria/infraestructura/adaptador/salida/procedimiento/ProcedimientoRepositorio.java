package org.veterinaria.infraestructura.adaptador.salida.procedimiento;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.procedimiento.IProcedimientoRepositorio;
import org.veterinaria.dominio.modelo.procedimiento.ProcedimientoEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProcedimientoRepositorio implements PanacheMongoRepository<ProcedimientoEntidad>, IProcedimientoRepositorio {
  @Override
  public List<ProcedimientoEntidad> obtenerTodosProcedimiento() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public ProcedimientoEntidad obtenerProcedimientoPorId(String idProcedimiento) {
    return findEntidadById(idProcedimiento)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(ProcedimientoEntidad::new);
  }

  @Override
  public ProcedimientoEntidad crearProcedimiento(ProcedimientoEntidad procedimiento) {
    procedimiento.setBorrado(false);
    procedimiento.persist();
    return procedimiento;
  }

  @Override
  public ProcedimientoEntidad actualizarProcedimiento(String idProcedimiento, ProcedimientoEntidad procedimiento) {
    return findEntidadById(idProcedimiento)
          .map(p -> {
            p.setProcedimiento(procedimiento.getProcedimiento());
            p.setDescripcion(procedimiento.getDescripcion());
            p.setBorrado(procedimiento.getBorrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Procedimiento no encontrado"));
  }

  @Override
  public ProcedimientoEntidad eliminarProcedimiento(String idProcedimiento) {
    ProcedimientoEntidad procedimiento = this.obtenerProcedimientoPorId(idProcedimiento);
    procedimiento.setBorrado(true);
    return this.actualizarProcedimiento(idProcedimiento, procedimiento);
  }

  private Optional<ProcedimientoEntidad> findEntidadById(String idProcedimiento) {
    return findByIdOptional(new ObjectId(idProcedimiento));
  }
}
