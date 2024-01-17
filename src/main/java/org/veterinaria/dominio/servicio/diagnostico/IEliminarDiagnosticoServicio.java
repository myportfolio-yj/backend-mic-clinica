package org.veterinaria.dominio.servicio.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

public interface IEliminarDiagnosticoServicio {
  DiagnosticoSalida eliminarDiagnostico(String idDiagnostico);
}
