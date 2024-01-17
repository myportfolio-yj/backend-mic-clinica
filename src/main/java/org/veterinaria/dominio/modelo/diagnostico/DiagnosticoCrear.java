package org.veterinaria.dominio.modelo.diagnostico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoCrear {
  private String diagnostico;
  private String detalle;
}
