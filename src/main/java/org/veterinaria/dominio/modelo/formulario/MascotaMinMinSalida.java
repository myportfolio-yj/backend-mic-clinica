package org.veterinaria.dominio.modelo.formulario;

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
public class MascotaMinMinSalida {
  private String nombre;
  private String apellido;
  private String id;
  private String codIdentificacion;
}
