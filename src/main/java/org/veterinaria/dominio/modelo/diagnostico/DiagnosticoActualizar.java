package org.veterinaria.dominio.modelo.diagnostico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoActualizar {
  private String diagnostico;
  private String detalle;
}
