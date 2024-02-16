package org.veterinaria.infraestructura.adaptador.salida.atencion;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
import org.veterinaria.aplicacion.puertos.salida.atencion.IAtencionRepositorio;
import org.veterinaria.dominio.modelo.atencion.AtencionEntidad;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AtencionRepositorio implements PanacheMongoRepository<AtencionEntidad>, IAtencionRepositorio {
  @Override
  public List<AtencionEntidad> obtenerTodosAtencion() {
    return listAll().parallelStream()
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .toList();
  }

  @Override
  public AtencionEntidad obtenerAtencionPorId(String idAtencion) {
    return findEntidadById(idAtencion)
          .filter(p -> p.getBorrado() == null || !p.getBorrado())
          .orElseGet(AtencionEntidad::new);
  }

  @Override
  public AtencionEntidad crearAtencion(AtencionEntidad atencionEntidad) {
    atencionEntidad.setBorrado(false);
    atencionEntidad.persist();
    return atencionEntidad;
  }

  @Override
  public AtencionEntidad actualizarAtencion(String idAtencion, AtencionEntidad atencion) {
    return findEntidadById(idAtencion)
          .map(p -> {
            p.setIdCita(atencion.getIdCita());
            p.setMotivo(atencion.getMotivo());
            p.setPeso(atencion.getPeso());
            p.setTemperatura(atencion.getTemperatura());
            p.setFrecuenciaRespiratoria(atencion.getFrecuenciaRespiratoria());
            p.setFrecuenciaCardiaca(atencion.getFrecuenciaCardiaca());
            p.setIdDiagnostico(atencion.getIdDiagnostico());
            p.setIdProcedimiento(atencion.getIdProcedimiento());
            p.setDetalleDiagnostico(atencion.getDetalleDiagnostico());
            p.setDetalleProcedimiento(atencion.getDetalleProcedimiento());
            p.setCerrado(atencion.getCerrado());
            update(p);
            return p;
          })
          .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
  }

  @Override
  public AtencionEntidad eliminarAtencion(String idAtencion) {
    AtencionEntidad atencionEntidad = this.obtenerAtencionPorId(idAtencion);
    atencionEntidad.setBorrado(true);
    return this.actualizarAtencion(idAtencion, atencionEntidad);
  }

  private Optional<AtencionEntidad> findEntidadById(String idTipoCita) {
    return findByIdOptional(new ObjectId(idTipoCita));
  }
}
