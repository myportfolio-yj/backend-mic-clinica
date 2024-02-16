package org.veterinaria.infraestructura.adaptador.entrada.atencion;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.atencion.IAtencionResource;
import org.veterinaria.dominio.modelo.atencion.AtencionActualizar;
import org.veterinaria.dominio.modelo.atencion.AtencionCrear;
import org.veterinaria.dominio.modelo.atencion.AtencionSalida;
import org.veterinaria.dominio.servicio.atencion.IAtencionServicio;

public class AtencionResource implements IAtencionResource {
  private final IAtencionServicio servicio;

  @Inject
  public AtencionResource(IAtencionServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response putAtencion(String idAtencion, AtencionActualizar atencionActualizar) {
    AtencionSalida atencionSalida = servicio.actualizarAtencion(idAtencion, atencionActualizar);
    return Response.ok(atencionSalida).build();
  }

  @Override
  public Response postAtencion(AtencionCrear atencionCrear) {
    AtencionSalida atencionSalida = servicio.crearAtencion(atencionCrear);
    return Response.status(Response.Status.CREATED).entity(atencionSalida).build();
  }

  @Override
  public Response deleteAtencion(String idAtencion) {
    AtencionSalida atencionSalida = servicio.eliminarAtencion(idAtencion);
    return Response.status(Response.Status.CREATED).entity(atencionSalida).build();
  }

  @Override
  public Response getAtencion() {
    return Response.ok(servicio.obtenerAtencion()).build();
  }

  @Override
  public Response getAtencionPorId(String idAtencion) {
    return Response.ok(servicio.obtenerAtencionPorId(idAtencion)).build();
  }
}
