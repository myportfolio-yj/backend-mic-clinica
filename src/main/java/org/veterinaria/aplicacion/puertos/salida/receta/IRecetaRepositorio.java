package org.veterinaria.aplicacion.puertos.salida.receta;

import org.veterinaria.dominio.modelo.receta.RecetaEntidad;

import java.util.List;

public interface IRecetaRepositorio {
  List<RecetaEntidad> obtenerTodosReceta();

  RecetaEntidad obtenerRecetaPorId(String idReceta);

  List<RecetaEntidad> obtenerRecetaPorIdCita(String idCita);

  RecetaEntidad crearReceta(RecetaEntidad receta);

  RecetaEntidad actualizarReceta(String idReceta, RecetaEntidad receta);

  RecetaEntidad eliminarReceta(String idReceta);
}
