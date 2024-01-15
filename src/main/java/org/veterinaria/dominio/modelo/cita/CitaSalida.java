package org.veterinaria.dominio.modelo.cita;

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
@RegisterForReflection
public class CitaSalida {
  private String id;
  private String idCliente;
  private String nombreMascota;
  private String idMascota;
  private String tipoCita;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private String fecha;
  private String turno;
  private String observaciones;
}
