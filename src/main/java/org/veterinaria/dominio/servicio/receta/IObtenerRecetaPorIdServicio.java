package org.veterinaria.dominio.servicio.receta;

import org.veterinaria.dominio.modelo.receta.RecetaSalida;

public interface IObtenerRecetaPorIdServicio {
  RecetaSalida obtenerRecetaPorId(String idReceta);
}
