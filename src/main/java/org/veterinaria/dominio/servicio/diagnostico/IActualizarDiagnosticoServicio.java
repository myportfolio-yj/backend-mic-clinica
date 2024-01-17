package org.veterinaria.dominio.servicio.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoActualizar;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

public interface IActualizarDiagnosticoServicio {
  DiagnosticoSalida actualizarDiagnostico(String idDiagnostico, DiagnosticoActualizar diagnostico);
}
