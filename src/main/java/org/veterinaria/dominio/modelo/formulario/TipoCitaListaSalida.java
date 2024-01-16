package org.veterinaria.dominio.modelo.formulario;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class TipoCitaListaSalida {
  private String id;
  private String tipoCita;
  private List<ReservaPeluquero> reservasPeluquero;
  private List<ReservaVeterinario> reservasVeterinario;
}
