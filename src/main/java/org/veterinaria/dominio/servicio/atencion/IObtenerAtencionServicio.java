package org.veterinaria.dominio.servicio.atencion;

import org.veterinaria.dominio.modelo.atencion.AtencionSalida;

import java.util.List;

public interface IObtenerAtencionServicio {
  List<AtencionSalida> obtenerAtencion();
}
