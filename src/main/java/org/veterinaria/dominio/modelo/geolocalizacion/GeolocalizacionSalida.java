package org.veterinaria.dominio.modelo.geolocalizacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.cita.ClienteMinSalida;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@RegisterForReflection
public class GeolocalizacionSalida {
  private String id;
  private MascotaMinSalida mascota;
  private List<ClienteMinSalida> cliente;
  private String url;
  private String telefono;
  private String fecha;
  private String hora;
}
