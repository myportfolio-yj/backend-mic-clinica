package org.veterinaria.infraestructura.adaptador.salida.cita;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.cita.ICitaRepositorio;
import org.veterinaria.dominio.modelo.cita.CitaEntidad;

import java.time.LocalDate;
import java.time.ZoneId;
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
  public List<CitaEntidad> obtenerTodosCitaAtendidas() {
    return listAll().parallelStream()
          .filter(p -> ((p.getCheckIn() != null && p.getCheckIn() == true) && (p.getDelete() == null || !p.getDelete())))
          .toList();
  }

  @Override
  public List<CitaEntidad> obtenerCitasVigentes() {
    LocalDate hoy = LocalDate.now();
    return this.obtenerTodosCita().parallelStream()
          .filter(p -> (p.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(hoy) ||
                p.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(hoy)) && (
                p.getCheckIn() == null || !p.getCheckIn()
          ))
          .toList();
  }

  @Override
  public List<CitaEntidad> obtenerCitasVigentesPorIdCliente(String idCliente) {
    return this.obtenerCitasVigentes().parallelStream()
          .filter(p -> p.getIdCliente().equals(idCliente))
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
            p.setAtencionesPeluqueria(p.getAtencionesPeluqueria());
            p.setFecha(cita.getFecha());
            p.setTurno(cita.getTurno());
            p.setObservaciones(cita.getObservaciones());
            p.setDelete(cita.getDelete());
            if (cita.getCheckIn() != null) {
              p.setCheckIn(cita.getCheckIn());
            }
            p.setIdAtencion(cita.getIdAtencion());
            p.setRecetas(cita.getRecetas());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("Cita no encontrado"));
  }

  @Override
  public CitaEntidad eliminarCita(String idCita) {
    CitaEntidad cita = this.obtenerCitaPorId(idCita);
    cita.setDelete(true);
    return this.actualizarCita(idCita, cita);
  }

  private Optional<CitaEntidad> findEntidadById(String idCita) {
    return findByIdOptional(new ObjectId(idCita));
  }
}
