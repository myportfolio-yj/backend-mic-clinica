package org.veterinaria.dominio.servicio.receta;

import org.veterinaria.dominio.modelo.receta.RecetaCrear;
import org.veterinaria.dominio.modelo.receta.RecetaSalida;

public interface ICrearRecetaServicio {
  RecetaSalida crearReceta(RecetaCrear receta);
}
