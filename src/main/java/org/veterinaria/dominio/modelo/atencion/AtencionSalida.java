package org.veterinaria.dominio.modelo.atencion;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class AtencionSalida {
  private String id;
  private String idCita;
  private String motivo;
  private Double peso;
  private Double temperatura;
  private Integer frecuenciaRespiratoria;
  private Integer frecuenciaCardiaca;
  private String idDiagnostico;
  private String idProcedimiento;
  private String detalleDiagnostico;
  private String detalleProcedimiento;
  private Boolean cerrado;
}
