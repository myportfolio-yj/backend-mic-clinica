package org.veterinaria.dominio.modelo.geolocalizacion;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.veterinaria.dominio.modelo.cita.ClienteMinSalida;
import org.veterinaria.dominio.modelo.mascota.EspecieSalida;
import org.veterinaria.dominio.modelo.mascota.RazaSalida;
import org.veterinaria.dominio.modelo.mascota.SexoSalida;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MascotaMinMinSalida {
  private String id;
  private String codIdentificacion;
  private String nombre;
  private String apellido;
  private String fechaNacimiento;
  private SexoSalida sexo;
  private EspecieSalida especie;
  private RazaSalida raza;
  private Boolean esterilizado;
  private List<ClienteMinSalida> clientes;
}
