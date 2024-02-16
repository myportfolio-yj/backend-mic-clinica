package org.veterinaria.infraestructura.adaptador.salida.receta;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.receta.IRecetaRepositorio;
import org.veterinaria.dominio.modelo.receta.RecetaEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RecetaRepositorio implements PanacheMongoRepository<RecetaEntidad>, IRecetaRepositorio {
  @Override
  public List<RecetaEntidad> obtenerTodosReceta() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public RecetaEntidad obtenerRecetaPorId(String idReceta) {
    return findEntidadById(idReceta)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(RecetaEntidad::new);
  }

  @Override
  public List<RecetaEntidad> obtenerRecetaPorIdCita(String idCita) {
    return listAll().parallelStream()
          .filter(p ->
                (p.getBorrado() == null || !p.getBorrado()) &&
                      (p.getIdCita().equals(idCita))
          )
          .toList();
  }

  @Override
  public RecetaEntidad crearReceta(RecetaEntidad atencionEntidad) {
    atencionEntidad.setBorrado(false);
    atencionEntidad.persist();
    return atencionEntidad;
  }

  @Override
  public RecetaEntidad actualizarReceta(String idReceta, RecetaEntidad receta) {
    return findEntidadById(idReceta)
          .map(p -> {
            p.setIdCita(receta.getIdCita());
            p.setIdMedicamento(receta.getIdMedicamento());
            p.setCantidad(receta.getCantidad());
            p.setDosis(receta.getDosis());
            p.setIndicaciones(receta.getIndicaciones());
            p.setBorrado(receta.getBorrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
  }

  @Override
  public RecetaEntidad eliminarReceta(String idReceta) {
    RecetaEntidad atencionEntidad = this.obtenerRecetaPorId(idReceta);
    atencionEntidad.setBorrado(true);
    return this.actualizarReceta(idReceta, atencionEntidad);
  }

  private Optional<RecetaEntidad> findEntidadById(String idTipoCita) {
    return findByIdOptional(new ObjectId(idTipoCita));
  }
}
