package org.veterinaria.dominio.modelo.geolocalizacion;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class GeolocalizacionSalida {
  private String id;
  private MascotaMinSalida mascota;
  private String url;
  private String telefono;
  private String fecha;
  private String hora;
}
