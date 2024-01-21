package org.veterinaria.dominio.servicio.diagnostico;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.veterinaria.aplicacion.puertos.salida.diagnostico.IDiagnosticoRepositorio;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoActualizar;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoCrear;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoEntidad;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

import java.util.List;

@ApplicationScoped
public class DiagnosticoServicio implements IDiagnosticoServicio {

  private final IDiagnosticoRepositorio repositorio;

  @Inject
  public DiagnosticoServicio(IDiagnosticoRepositorio repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public List<DiagnosticoSalida> obtenerDiagnostico() {
    List<DiagnosticoEntidad> diagnosticoEntidades = repositorio.obtenerTodosDiagnostico();
    return diagnosticoEntidades.parallelStream().map(p -> DiagnosticoSalida.builder()
                .id(p.id.toString())
                .diagnostico(p.getDiagnostico())
                .detalle(p.getDetalle())
                .build())
          .toList();
  }

  @Override
  public DiagnosticoSalida obtenerDiagnosticoPorId(String idDiagnostico) {
    DiagnosticoEntidad diagnosticoEntidades = repositorio.obtenerDiagnosticoPorId(idDiagnostico);
    return DiagnosticoSalida.builder()
          .id(diagnosticoEntidades.id.toString())
          .diagnostico(diagnosticoEntidades.getDiagnostico())
          .detalle(diagnosticoEntidades.getDetalle())
          .build();
  }

  @Override
  public DiagnosticoSalida crearDiagnostico(DiagnosticoCrear diagnosticoCrear) {
    DiagnosticoEntidad diagnosticoEntidad = new DiagnosticoEntidad();
    diagnosticoEntidad.setDiagnostico(diagnosticoCrear.getDiagnostico());
    diagnosticoEntidad.setDetalle(diagnosticoCrear.getDetalle());
    diagnosticoEntidad = repositorio.crearDiagnostico(diagnosticoEntidad);
    return this.obtenerDiagnosticoPorId(diagnosticoEntidad.id.toString());
  }

  @Override
  public DiagnosticoSalida actualizarDiagnostico(String idDiagnostico, DiagnosticoActualizar diagnosticoActualizar) {
    DiagnosticoEntidad diagnosticoEntidad = new DiagnosticoEntidad();
    diagnosticoEntidad.setDiagnostico(diagnosticoActualizar.getDiagnostico());
    diagnosticoEntidad.setDetalle(diagnosticoActualizar.getDetalle());
    repositorio.actualizarDiagnostico(idDiagnostico, diagnosticoEntidad);
    return this.obtenerDiagnosticoPorId(idDiagnostico);
  }

  @Override
  public DiagnosticoSalida eliminarDiagnostico(String idDiagnostico) {
    DiagnosticoEntidad diagnosticoEntidad = repositorio.eliminarDiagnostico(idDiagnostico);
    return DiagnosticoSalida.builder()
          .id(diagnosticoEntidad.id.toString())
          .diagnostico(diagnosticoEntidad.getDiagnostico())
          .detalle(diagnosticoEntidad.getDetalle())
          .build();
  }
}
