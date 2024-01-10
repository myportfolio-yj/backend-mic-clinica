package org.veterinaria.aplicacion.puertos.salida.AtencionPeluquero;

import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroEntidad;

import java.util.List;

public interface IAtencionPeluqueroRepositorio {
  List<AtencionPeluqueroEntidad> obtenerTodosAtencionPeluquero();

  AtencionPeluqueroEntidad obtenerAtencionPeluqueroPorId(String idAtencionPeluquero);

  AtencionPeluqueroEntidad crearAtencionPeluquero(AtencionPeluqueroEntidad atencionPeluquero);

  AtencionPeluqueroEntidad actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroEntidad atencionPeluquero);

  AtencionPeluqueroEntidad eliminarAtencionPeluquero(String idAtencionPeluquero);
}
