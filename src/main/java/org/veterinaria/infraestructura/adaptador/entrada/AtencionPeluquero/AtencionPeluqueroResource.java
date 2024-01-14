package org.veterinaria.infraestructura.adaptador.entrada.AtencionPeluquero;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.AtencionPeluquero.IAtencionPeluqueroResource;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroActualizar;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroSalida;
import org.veterinaria.dominio.servicio.AtencionPeluquero.IAtencionPeluqueroServicio;

public class AtencionPeluqueroResource implements IAtencionPeluqueroResource {
  @Inject
  IAtencionPeluqueroServicio servicio;

  @Override
  public Response putAtencionPeluquero(String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluqueroActualizar) {
    AtencionPeluqueroSalida atencionPeluqueroSalida = servicio.actualizarAtencionPeluquero(idAtencionPeluquero, atencionPeluqueroActualizar);
    return Response.ok(atencionPeluqueroSalida).build();
  }

  @Override
  public Response postAtencionPeluquero(AtencionPeluqueroCrear atencionPeluqueroCrear) {
    AtencionPeluqueroSalida atencionPeluqueroSalida = servicio.crearAtencionPeluquero(atencionPeluqueroCrear);
    return Response.status(Response.Status.CREATED).entity(atencionPeluqueroSalida).build();
  }

  @Override
  public Response deleteAtencionPeluquero(String idAtencionPeluquero) {
    AtencionPeluqueroSalida atencionPeluqueroSalida = servicio.eliminarAtencionPeluquero(idAtencionPeluquero);
    return Response.status(Response.Status.CREATED).entity(atencionPeluqueroSalida).build();
  }

  @Override
  public Response getAtencionPeluquero() {
    return Response.ok(servicio.obtenerAtencionPeluquero()).build();
  }

  @Override
  public Response getAtencionPeluqueroPorId(String idAtencionPeluquero) {
    return Response.ok(servicio.obtenerAtencionPeluqueroPorId(idAtencionPeluquero)).build();
  }
}
