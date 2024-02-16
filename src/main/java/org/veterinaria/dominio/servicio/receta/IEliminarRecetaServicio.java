package org.veterinaria.dominio.servicio.receta;

import org.veterinaria.dominio.modelo.receta.RecetaSalida;

public interface IEliminarRecetaServicio {
  RecetaSalida eliminarReceta(String idReceta);
}
