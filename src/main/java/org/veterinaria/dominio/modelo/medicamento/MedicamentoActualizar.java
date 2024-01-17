package org.veterinaria.dominio.modelo.medicamento;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoActualizar {
  private String medicamento;
  private String descripcion;
}
