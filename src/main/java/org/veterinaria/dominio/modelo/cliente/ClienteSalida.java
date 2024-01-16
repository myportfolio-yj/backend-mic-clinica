package org.veterinaria.dominio.modelo.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.mascota.MascotaSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@RegisterForReflection
public class ClienteSalida {
  private String id;
  private String nombres;
  private String apellidos;
  private List<MascotaSalida> mascotas;
}
