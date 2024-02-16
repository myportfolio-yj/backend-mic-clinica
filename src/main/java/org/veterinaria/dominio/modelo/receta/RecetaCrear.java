package org.veterinaria.dominio.modelo.receta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecetaCrear {
  private String idCita;
  private String idMedicamento;
  private Double cantidad;
  private Double dosis;
  private String indicaciones;
}
