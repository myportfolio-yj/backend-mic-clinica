package org.veterinaria.dominio.modelo.medicamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoActualizar {
  private String medicamento;
  private String descripcion;
}
