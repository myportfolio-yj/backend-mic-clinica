package org.veterinaria.dominio.modelo.atencionpeluquero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtencionPeluqueroActualizar {
  private String atencionPeluquero;
}
