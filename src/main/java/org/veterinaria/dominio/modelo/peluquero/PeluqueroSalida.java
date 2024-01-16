package org.veterinaria.dominio.modelo.peluquero;

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
public class PeluqueroSalida {
  private String id;
  private String nombres;
  private String apellidos;
}
