package org.veterinaria.dominio.modelo.turno;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class TurnoSalida {
  private String id;
  private TipoCitaSalida tipoCita;
  private String turno;
  private String diaSemana;
  private Integer valor;
}
