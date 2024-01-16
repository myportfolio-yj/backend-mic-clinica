package org.veterinaria.dominio.modelo.formulario;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ReservaPeluquero {
  private PeluqueroSalida peluquero;
  private List<Turno2> turnos;
}
