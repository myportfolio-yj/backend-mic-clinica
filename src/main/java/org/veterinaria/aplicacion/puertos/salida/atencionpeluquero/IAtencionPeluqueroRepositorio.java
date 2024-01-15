package org.veterinaria.aplicacion.puertos.salida.atencionpeluquero;

import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroEntidad;

import java.util.List;

public interface IAtencionPeluqueroRepositorio {
  List<AtencionPeluqueroEntidad> obtenerTodosAtencionPeluquero();

  AtencionPeluqueroEntidad obtenerAtencionPeluqueroPorId(String idAtencionPeluquero);

  AtencionPeluqueroEntidad crearAtencionPeluquero(AtencionPeluqueroEntidad atencionPeluquero);

  AtencionPeluqueroEntidad actualizarAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroEntidad atencionPeluquero);

  AtencionPeluqueroEntidad eliminarAtencionPeluquero(String idAtencionPeluquero);
}
