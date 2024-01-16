package org.veterinaria.dominio.modelo.veterinario;

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
public class VeterinarioSalida {
  private String id;
  private String codVeterinario;
  private String nombres;
  private String apellidos;
}
