package org.veterinaria.infraestructura.adaptador.salida.atencionpeluquero;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.atencionpeluquero.IAtencionPeluqueroRepositorio;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AtencionPeluqueroRepositorio implements PanacheMongoRepository<AtencionPeluqueroEntidad>, IAtencionPeluqueroRepositorio {
  @Override
  public List<AtencionPeluqueroEntidad> obtenerTodosAtencionPeluquero() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public AtencionPeluqueroEntidad obtenerAtencionPeluqueroPorId(String idAtencionPeluquero) {
    return findEntidadById(idAtencionPeluquero)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseGet(AtencionPeluqueroEntidad::new);
  }

  @Override
  public AtencionPeluqueroEntidad crearAtencionPeluquero(AtencionPeluqueroEntidad atencionPeluqueroEntidad) {
    atencionPeluqueroEntidad.setDelete(false);
    atencionPeluqueroEntidad.persist();
    return atencionPeluqueroEntidad;
  }

  @Override
  public AtencionPeluqueroEntidad actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroEntidad atencionPeluquero) {
    return findEntidadById(idAtencionPeluquero)
          .map(p -> {
            p.setAtencionPeluquero(atencionPeluquero.getAtencionPeluquero());
            p.setDelete(atencionPeluquero.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
  }

  @Override
  public AtencionPeluqueroEntidad eliminarAtencionPeluquero(String idAtencionPeluquero) {
    AtencionPeluqueroEntidad atencionPeluqueroEntidad = this.obtenerAtencionPeluqueroPorId(idAtencionPeluquero);
    atencionPeluqueroEntidad.setDelete(true);
    return this.actualizarAtencionPeluquero(idAtencionPeluquero, atencionPeluqueroEntidad);
  }

  private Optional<AtencionPeluqueroEntidad> findEntidadById(String idTipoCita) {
    return findByIdOptional(new ObjectId(idTipoCita));
  }
}
