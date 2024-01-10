package org.veterinaria.infraestructura.adaptador.salida.Cita;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.Cita.ICitaRepositorio;
import org.veterinaria.dominio.modelo.Cita.CitaEntidad;

import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class CitaRepositorio implements PanacheMongoRepository<CitaEntidad>, ICitaRepositorio {
  @Override
  public List<CitaEntidad> obtenerTodosCita() {
    return listAll().parallelStream()
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .toList();
  }

  @Override
  public CitaEntidad obtenerCitaPorId(String idCita) {
    return findEntidadById(idCita)
          .filter(p -> p.getDelete() == null || !p.getDelete())
          .orElseGet(CitaEntidad::new);
  }

  @Override
  public CitaEntidad crearCita(CitaEntidad cita) {
    cita.setDelete(false);
    cita.persist();
    return cita;
  }

  @Override
  public CitaEntidad actualizarCita(String idCita, CitaEntidad cita) {
    return findEntidadById(idCita)
          .map(p -> {
            p.setIdMascota(cita.getIdMascota());
            p.setIdTipoCita(cita.getIdTipoCita());
            p.setAtencionesPeluqueria(cita.getAtencionesPeluqueria());
            p.setFecha(cita.getFecha());
            p.setTurno(cita.getTurno());
            p.setObservaciones(cita.getObservaciones());
            p.setDelete(cita.getDelete());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Cita no encontrado"));
  }

  @Override
  public CitaEntidad eliminarCita(String idCita) {
    CitaEntidad cita = this.obtenerCitaPorId(idCita);
    cita.setDelete(true);
    return this.actualizarCita(idCita,cita);
  }
  private Optional<CitaEntidad> findEntidadById(String idCita) {
    return findByIdOptional(new ObjectId(idCita));
  }
}
