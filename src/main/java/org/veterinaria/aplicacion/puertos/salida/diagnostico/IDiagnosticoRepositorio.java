package org.veterinaria.aplicacion.puertos.salida.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoEntidad;

import java.util.List;

public interface IDiagnosticoRepositorio {
  List<DiagnosticoEntidad> obtenerTodosDiagnostico();

  DiagnosticoEntidad obtenerDiagnosticoPorId(String idDiagnostico);

  DiagnosticoEntidad crearDiagnostico(DiagnosticoEntidad diagnosticoEntidad);

  DiagnosticoEntidad actualizarDiagnostico(String idDiagnostico, DiagnosticoEntidad diagnosticoEntidad);

  DiagnosticoEntidad eliminarDiagnostico(String idDiagnostico);
}
