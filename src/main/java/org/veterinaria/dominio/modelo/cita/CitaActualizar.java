package org.veterinaria.dominio.modelo.cita;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CitaActualizar extends CitaPadre {
  private String idCliente;
  private String idMascota;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private String fecha;
  private String turno;
  private String observaciones;
}
