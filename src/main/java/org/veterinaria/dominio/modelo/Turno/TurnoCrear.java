package org.veterinaria.dominio.modelo.Turno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurnoCrear {
  private String idTipoCita;
  private String turno;
  private String diaSemana;
  private Integer valor;
}
