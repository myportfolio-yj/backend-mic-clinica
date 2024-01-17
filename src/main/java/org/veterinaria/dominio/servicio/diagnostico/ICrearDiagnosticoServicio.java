package org.veterinaria.dominio.servicio.diagnostico;

import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoCrear;
import org.veterinaria.dominio.modelo.diagnostico.DiagnosticoSalida;

public interface ICrearDiagnosticoServicio {
  DiagnosticoSalida crearDiagnostico(DiagnosticoCrear diagnosticoCrear);
}
