package org.veterinaria.dominio.servicio.atencion;

import org.veterinaria.dominio.modelo.atencion.AtencionSalida;

public interface IEliminarAtencionServicio {
  AtencionSalida eliminarAtencion(String idAtencion);
}
