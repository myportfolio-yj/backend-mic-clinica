package org.veterinaria.dominio.modelo.mascota;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MascotaPadre {
  protected String nombre;
  protected String apellido;
  protected String fechaNacimiento;
  protected SexoSalida sexo;
  protected EspecieSalida especie;
  protected RazaSalida raza;
  protected Boolean esterilizado;
  protected List<AlergiaSalida> alergias;
  protected List<VacunaSalida> vacunas;
  protected String foto;
  protected String qr;
}
