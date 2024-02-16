package org.veterinaria.dominio.servicio.receta;

import org.veterinaria.dominio.modelo.receta.RecetaActualizar;
import org.veterinaria.dominio.modelo.receta.RecetaSalida;

public interface IActualizarRecetaServicio {
  RecetaSalida actualizarReceta(String idReceta, RecetaActualizar receta);
}
