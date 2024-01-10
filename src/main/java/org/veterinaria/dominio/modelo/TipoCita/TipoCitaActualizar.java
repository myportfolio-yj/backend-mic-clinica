package org.veterinaria.dominio.modelo.TipoCita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCitaActualizar {
  private String tipoCita;
}
