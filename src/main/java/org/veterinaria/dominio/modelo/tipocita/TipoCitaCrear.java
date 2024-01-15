package org.veterinaria.dominio.modelo.tipocita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCitaCrear {
  private String tipoCita;
}
