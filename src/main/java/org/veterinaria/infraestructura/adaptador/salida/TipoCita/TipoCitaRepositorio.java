package org.veterinaria.infraestructura.adaptador.salida.TipoCita;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.TipoCita.ITipoCitaRepositorio;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TipoCitaRepositorio implements PanacheMongoRepository<TipoCitaEntidad>, ITipoCitaRepositorio {
  @Override
  public List<TipoCitaEntidad> obtenerTodosTipoCita() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public TipoCitaEntidad obtenerTipoCitaPorId(String idTipoCita) {
    return findEntidadById(idTipoCita)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseGet(TipoCitaEntidad::new);
  }

  @Override
  public TipoCitaEntidad crearTipoCita(TipoCitaEntidad tipoCita) {
    tipoCita.setDelete(false);
    tipoCita.persist();
    return tipoCita;
  }

  @Override
  public TipoCitaEntidad actualizarTipoCita(String idTipoCita, TipoCitaEntidad tipoCita) {
    return findEntidadById(idTipoCita)
          .map(p -> {
            p.setTipoCita(tipoCita.getTipoCita());
            p.setDelete(tipoCita.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
  }

  @Override
  public TipoCitaEntidad eliminarTipoCita(String idTipoCita) {
    TipoCitaEntidad tipoCita = this.obtenerTipoCitaPorId(idTipoCita);
    tipoCita.setDelete(true);
    return this.actualizarTipoCita(idTipoCita, tipoCita);
  }

  private Optional<TipoCitaEntidad> findEntidadById(String idTipoCita) {
    return findByIdOptional(new ObjectId(idTipoCita));
  }
}
