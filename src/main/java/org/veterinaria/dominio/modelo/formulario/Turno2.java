package org.veterinaria.dominio.modelo.formulario;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Turno2 {
  private String fecha;
  private String dia;
  private List<String> turnos;
}
