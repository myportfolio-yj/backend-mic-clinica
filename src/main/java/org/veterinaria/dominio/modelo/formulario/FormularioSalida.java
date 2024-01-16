package org.veterinaria.dominio.modelo.formulario;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class FormularioSalida {
  private List<MascotaMinMinSalida> mascotas;
  private List<TipoCitaListaSalida> tiposCita;
  private List<AtencionPeluqueroSalida> atencionesPeluqueria;
}
