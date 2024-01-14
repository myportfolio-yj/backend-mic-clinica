package org.veterinaria.infraestructura.adaptador.entrada.Cita;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cita.ICitaVigenteResource;
import org.veterinaria.dominio.servicio.Cita.ICitaServicio;

public class CitaVigenteResource implements ICitaVigenteResource {
  @Inject
  ICitaServicio servicio;

  @Override
  public Response getCitaVigentes() {
    return Response.ok(servicio.obtenerCitasVigentes()).build();
  }

  @Override
  public Response getCitaVigentesPorIdCliente(String idCliente) {
    return Response.ok(servicio.obtenerCitasVigentesPorIdCliente(idCliente)).build();
  }
}
