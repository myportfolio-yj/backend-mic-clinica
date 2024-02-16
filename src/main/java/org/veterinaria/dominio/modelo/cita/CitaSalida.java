package org.veterinaria.dominio.modelo.cita;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class CitaSalida {
  private String id;
  private ClienteMinSalida cliente;
  private String nombreMascota;
  private String idMascota;
  private MascotaMinSalida mascota;
  private String tipoCita;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private String fecha;
  private String turno;
  private String observaciones;
  private Boolean checkIn;
  private String idAtencion;
  private List<String> recetas;
}
