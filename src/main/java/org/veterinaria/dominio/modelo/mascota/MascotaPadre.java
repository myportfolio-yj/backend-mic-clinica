package org.veterinaria.dominio.modelo.mascota;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MascotaPadre {
  public String nombre;
  public String apellido;
  public String fechaNacimiento;
  public SexoSalida sexo;
  public EspecieSalida especie;
  public RazaSalida raza;
  public Boolean esterilizado;
  public List<AlergiaSalida> alergias;
  public List<VacunaSalida> vacunas;
  public String foto;
  public String qr;
}
