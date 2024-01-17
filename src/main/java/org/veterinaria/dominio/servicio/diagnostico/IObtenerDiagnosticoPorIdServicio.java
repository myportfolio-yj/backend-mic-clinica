package org.veterinaria.dominio.servicio.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

public interface IObtenerDiagnosticoPorIdServicio {
  DiagnosticoSalida obtenerDiagnosticoPorId(String idDiagnostico);
}
