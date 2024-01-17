package org.veterinaria.dominio.modelo.procedimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcedimientoCrear {
  private String procedimiento;
  private String descripcion;
}
