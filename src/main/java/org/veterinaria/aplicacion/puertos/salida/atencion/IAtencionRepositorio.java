package org.veterinaria.aplicacion.puertos.salida.atencion;

import org.veterinaria.dominio.modelo.atencion.AtencionEntidad;

import java.util.List;

public interface IAtencionRepositorio {
  List<AtencionEntidad> obtenerTodosAtencion();

  AtencionEntidad obtenerAtencionPorId(String idAtencion);

  AtencionEntidad crearAtencion(AtencionEntidad atencion);

  AtencionEntidad actualizarAtencion(String idAtencion, AtencionEntidad atencion);

  AtencionEntidad eliminarAtencion(String idAtencion);
}
