package org.veterinaria.dominio.modelo.geolocalizacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeolocalizacionActualizar {
  private String idMascota;
  private String latitud;
  private String longitud;
  private String telefono;
}
