package org.veterinaria.dominio.servicio.receta;

import org.veterinaria.dominio.modelo.receta.RecetaSalida;

import java.util.List;

public interface IObtenerRecetaServicio {
  List<RecetaSalida> obtenerReceta();
}
