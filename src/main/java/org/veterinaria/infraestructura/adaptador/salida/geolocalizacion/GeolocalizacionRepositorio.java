package org.veterinaria.infraestructura.adaptador.salida.geolocalizacion;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.geolocalizacion.IGeolocalizacionRepositorio;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GeolocalizacionRepositorio implements PanacheMongoRepository<GeolocalizacionEntidad>, IGeolocalizacionRepositorio {
  @Override
  public List<GeolocalizacionEntidad> obtenerTodosGeolocalizacion() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public GeolocalizacionEntidad obtenerGeolocalizacionPorId(String idGeolocalizacion) {
    return findEntidadById(idGeolocalizacion)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(GeolocalizacionEntidad::new);
  }

  @Override
  public List<GeolocalizacionEntidad> obtenerGeolocalizacionPorIdMascota(String idMascota) {
    return listAll().parallelStream()
          .filter(p -> p.getIdMascota().equals(idMascota))
          .toList();
  }

  @Override
  public GeolocalizacionEntidad crearGeolocalizacion(GeolocalizacionEntidad geolocalizacion) {
    geolocalizacion.setBorrado(false);
    geolocalizacion.persist();
    return geolocalizacion;
  }

  @Override
  public GeolocalizacionEntidad actualizarGeolocalizacion(String idGeolocalizacion, GeolocalizacionEntidad geolocalizacion) {
    return findEntidadById(idGeolocalizacion)
          .map(p -> {
            p.setIdMascota(geolocalizacion.getIdMascota());
            p.setLatitud(geolocalizacion.getLatitud());
            p.setLongitud(geolocalizacion.getLongitud());
            p.setTelefono(geolocalizacion.getTelefono());
            p.setFechaHora(geolocalizacion.getFechaHora());
            p.setBorrado(geolocalizacion.getBorrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Cita no encontrado"));
  }

  @Override
  public GeolocalizacionEntidad eliminarGeolocalizacion(String idGeolocalizacion) {
    GeolocalizacionEntidad geolocalizacion = this.obtenerGeolocalizacionPorId(idGeolocalizacion);
    geolocalizacion.setBorrado(true);
    return this.actualizarGeolocalizacion(idGeolocalizacion, geolocalizacion);
  }

  private Optional<GeolocalizacionEntidad> findEntidadById(String idGeolocalizacion) {
    return findByIdOptional(new ObjectId(idGeolocalizacion));
  }
}
