package org.veterinaria.dominio.servicio.atencion;

import org.veterinaria.dominio.modelo.atencion.AtencionActualizar;
import org.veterinaria.dominio.modelo.atencion.AtencionSalida;

public interface IActualizarAtencionServicio {
  AtencionSalida actualizarAtencion(String idAtencion, AtencionActualizar atencion);
}
