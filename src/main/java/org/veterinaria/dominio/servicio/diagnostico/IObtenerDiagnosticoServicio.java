package org.veterinaria.dominio.servicio.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

import java.util.List;

public interface IObtenerDiagnosticoServicio {
  List<DiagnosticoSalida> obtenerDiagnostico();
}
