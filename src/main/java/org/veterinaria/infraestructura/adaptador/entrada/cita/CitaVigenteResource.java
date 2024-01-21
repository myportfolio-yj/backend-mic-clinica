package org.veterinaria.infraestructura.adaptador.entrada.cita;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.cita.ICitaVigenteResource;
import org.veterinaria.dominio.servicio.cita.ICitaServicio;

public class CitaVigenteResource implements ICitaVigenteResource {
  private final ICitaServicio servicio;

  @Inject
  public CitaVigenteResource(ICitaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response getCitaVigentes() {
    return Response.ok(servicio.obtenerCitasVigentes()).build();
  }

  @Override
  public Response getCitaVigentesPorIdCliente(String idCliente) {
    return Response.ok(servicio.obtenerCitasVigentesPorIdCliente(idCliente)).build();
  }
}
