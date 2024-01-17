package org.veterinaria.dominio.modelo.medicamento;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class MedicamentoSalida {
  private String id;
  private String medicamento;
  private String descripcion;
}
