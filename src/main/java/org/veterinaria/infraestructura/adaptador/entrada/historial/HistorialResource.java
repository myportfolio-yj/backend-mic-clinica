package org.veterinaria.infraestructura.adaptador.entrada.historial;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.historias.IHistoriaResource;
import org.veterinaria.dominio.servicio.cita.ICitaServicio;

public class HistorialResource implements IHistoriaResource {
  private final ICitaServicio servicio;

  @Inject
  public HistorialResource(ICitaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response getHistorial() {
    return Response.ok(servicio.obtenerCitaHistorial()).build();
  }
}
