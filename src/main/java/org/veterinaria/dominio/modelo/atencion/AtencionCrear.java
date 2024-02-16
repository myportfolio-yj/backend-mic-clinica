package org.veterinaria.dominio.modelo.atencion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtencionCrear {
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
