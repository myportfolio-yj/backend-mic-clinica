package org.veterinaria.dominio.modelo.geolocalizacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeolocalizacionCrear {
  private String idMascota;
  private String latitud;
  private String longitud;
  private String telefono;
}
