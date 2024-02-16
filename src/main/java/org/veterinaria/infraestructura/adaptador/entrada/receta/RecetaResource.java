package org.veterinaria.infraestructura.adaptador.entrada.receta;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.receta.IRecetaResource;
import org.veterinaria.dominio.modelo.receta.RecetaActualizar;
import org.veterinaria.dominio.modelo.receta.RecetaCrear;
import org.veterinaria.dominio.modelo.receta.RecetaSalida;
import org.veterinaria.dominio.servicio.receta.IRecetaServicio;

public class RecetaResource implements IRecetaResource {
  private final IRecetaServicio servicio;

  @Inject
  public RecetaResource(IRecetaServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response putReceta(String idReceta, RecetaActualizar recetaActualizar) {
    RecetaSalida recetaSalida = servicio.actualizarReceta(idReceta, recetaActualizar);
    return Response.ok(recetaSalida).build();
  }

  @Override
  public Response postReceta(RecetaCrear recetaCrear) {
    RecetaSalida recetaSalida = servicio.crearReceta(recetaCrear);
    return Response.status(Response.Status.CREATED).entity(recetaSalida).build();
  }

  @Override
  public Response deleteReceta(String idReceta) {
    RecetaSalida recetaSalida = servicio.eliminarReceta(idReceta);
    return Response.status(Response.Status.CREATED).entity(recetaSalida).build();
  }

  @Override
  public Response getReceta() {
    return Response.ok(servicio.obtenerReceta()).build();
  }

  @Override
  public Response getRecetaPorId(String idReceta) {
    return Response.ok(servicio.obtenerRecetaPorId(idReceta)).build();
  }
}
