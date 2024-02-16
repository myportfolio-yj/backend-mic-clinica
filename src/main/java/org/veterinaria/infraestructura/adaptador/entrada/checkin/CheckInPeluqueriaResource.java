package org.veterinaria.infraestructura.adaptador.entrada.checkin;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.checkin.ICheckInPeluqueriaResource;
import org.veterinaria.dominio.modelo.cita.CitaSalida;
import org.veterinaria.dominio.servicio.cita.ICitaServicio;

public class CheckInPeluqueriaResource implements ICheckInPeluqueriaResource {
  private final ICitaServicio servicio;

  @Inject
  public CheckInPeluqueriaResource(ICitaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response checkInPeluqueria(String idCita) {
    CitaSalida citaSalida = servicio.checkIn(idCita);
    return Response.ok(citaSalida).build();
  }
}
