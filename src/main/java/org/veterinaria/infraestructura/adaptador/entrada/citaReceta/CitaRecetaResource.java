package org.veterinaria.infraestructura.adaptador.entrada.citaReceta;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.citaReceta.IObtenerRecetasCitaResource;
import org.veterinaria.dominio.servicio.receta.IRecetaServicio;

public class CitaRecetaResource implements IObtenerRecetasCitaResource {
  private final IRecetaServicio servicio;

  @Inject
  public CitaRecetaResource(IRecetaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response getRecetaPorIdCita(String idCita) {
    return Response.ok(servicio.obtenerRecetaPorIdCita(idCita)).build();
  }
}