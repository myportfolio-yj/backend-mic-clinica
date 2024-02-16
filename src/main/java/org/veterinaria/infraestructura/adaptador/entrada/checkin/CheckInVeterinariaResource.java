package org.veterinaria.infraestructura.adaptador.entrada.checkin;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.checkin.ICheckInVeterinariaResource;
import org.veterinaria.dominio.modelo.cita.CitaSalida;
import org.veterinaria.dominio.servicio.cita.ICitaServicio;

public class CheckInVeterinariaResource implements ICheckInVeterinariaResource {
  private final ICitaServicio servicio;

  @Inject
  public CheckInVeterinariaResource(ICitaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response checkInVeterinaria(String idCita) {
    CitaSalida citaSalida = servicio.checkIn(idCita);
    return Response.ok(citaSalida).build();
  }
}
