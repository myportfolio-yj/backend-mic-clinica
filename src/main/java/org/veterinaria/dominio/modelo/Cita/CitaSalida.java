package org.veterinaria.dominio.modelo.Cita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import io.quarkus.runtime.annotations.RegisterForReflection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class CitaSalida {
  private String id;
  private String nombreMascota;
  private String idMascota;
  private String tipoCita;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private String fecha;
  private String turno;
  private String observaciones;
}
