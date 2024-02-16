package org.veterinaria.dominio.servicio.atencion;

import org.veterinaria.dominio.modelo.atencion.AtencionCrear;
import org.veterinaria.dominio.modelo.atencion.AtencionSalida;

public interface ICrearAtencionServicio {
  AtencionSalida crearAtencion(AtencionCrear atencion);
}
