package org.veterinaria.infraestructura.adaptador.entrada.Cita;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.Cita.ICitaResource;
import org.veterinaria.dominio.modelo.Cita.CitaActualizar;
import org.veterinaria.dominio.modelo.Cita.CitaCrear;
import org.veterinaria.dominio.modelo.Cita.CitaSalida;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaSalida;
import org.veterinaria.dominio.servicio.Cita.ICitaServicio;

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
    return Response.ok(citaSalida).build();}

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
