package org.veterinaria.dominio.modelo.mascota;

import java.util.List;

public class MascotaPadre {
  public String nombre;
  public String apellido;
  public String fechaNacimiento;
  public Sexo sexo;
  public Especie especie;
  public Raza raza;
  public Boolean esterilizado;
  public List<Alergia> alergias;
  public List<Vacuna> vacunas;
  public String foto;
  public String qr;
}
