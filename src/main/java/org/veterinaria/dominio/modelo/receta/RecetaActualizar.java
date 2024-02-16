package org.veterinaria.dominio.modelo.receta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecetaActualizar {
  private Double cantidad;
  private Double dosis;
  private String indicaciones;
}
