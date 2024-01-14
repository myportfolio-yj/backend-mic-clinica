package org.veterinaria.infraestructura.adaptador.salida.Turno;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.Turno.ITurnoRepositorio;
import org.veterinaria.dominio.modelo.Turno.TurnoEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TurnoRepositorio implements PanacheMongoRepository<TurnoEntidad>, ITurnoRepositorio {
  @Override
  public List<TurnoEntidad> obtenerTodosTurno() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public TurnoEntidad obtenerTurnoPorId(String idTurno) {
    return findEntidadById(idTurno)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(TurnoEntidad::new);
  }

  @Override
  public TurnoEntidad crearTurno(TurnoEntidad turno) {
    turno.setBorrado(false);
    turno.persist();
    return turno;
  }

  @Override
  public TurnoEntidad actualizarTurno(String idTurno, TurnoEntidad turno) {
    return findEntidadById(idTurno)
          .map(p -> {
            p.setTurno(turno.getTurno());
            p.setBorrado(turno.getBorrado());
            p.setDiaSemana(turno.getDiaSemana());
            p.setDiaSemana(turno.getDiaSemana());
            p.setIdTipoCita(turno.getIdTipoCita());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
  }

  @Override
  public TurnoEntidad eliminarTurno(String idTurno) {
    TurnoEntidad turno = this.obtenerTurnoPorId(idTurno);
    turno.setBorrado(true);
    return this.actualizarTurno(idTurno, turno);
  }

  private Optional<TurnoEntidad> findEntidadById(String idTurno) {
    return findByIdOptional(new ObjectId(idTurno));
  }
}
