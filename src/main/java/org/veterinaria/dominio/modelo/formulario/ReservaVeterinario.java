package org.veterinaria.dominio.modelo.formulario;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ReservaVeterinario {
  private VeterinarioSalida verinario;
  private List<Turno2> turnos;
}
