package org.veterinaria.dominio.modelo.receta;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class RecetaSalida {
  private String id;
  private String idCita;
  private String idMedicamento;
  private MedicamentoSalida medicamento;
  private Double cantidad;
  private Double dosis;
  private String indicaciones;
}
