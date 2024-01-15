package org.veterinaria.infraestructura.adaptador.entrada.cita;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.cita.ICitaResource;
import org.veterinaria.dominio.modelo.cita.CitaActualizar;
import org.veterinaria.dominio.modelo.cita.CitaCrear;
import org.veterinaria.dominio.modelo.cita.CitaSalida;
import org.veterinaria.dominio.servicio.cita.ICitaServicio;

public class CitaResource implements ICitaResource {
  @Inject
  ICitaServicio servicio;

  @Override
  public Response postCita(CitaCrear cita) {
    CitaSalida citaSalida = servicio.crearCita(cita);
    return Response.status(Response.Status.CREATED).entity(citaSalida).build();
  }

  @Override
  public Response putCita(String idCita, CitaActualizar cita) {
    CitaSalida citaSalida = servicio.actualizarCita(idCita, cita);
    return Response.ok(citaSalida).build();
  }

  @Override
  public Response deleteCita(String idCita) {
    CitaSalida citaSalida = servicio.eliminarCita(idCita);
    return Response.status(Response.Status.CREATED).entity(citaSalida).build();
  }

  @Override
  public Response getCita() {
    return Response.ok(servicio.obtenerCita()).build();
  }

  @Override
  public Response getCitaPorId(String idCita) {
    return Response.ok(servicio.obtenerCitaPorId(idCita)).build();
  }
}
