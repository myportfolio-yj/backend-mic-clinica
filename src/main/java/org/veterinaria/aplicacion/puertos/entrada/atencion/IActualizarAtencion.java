package org.veterinaria.aplicacion.puertos.entrada.atencion;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.atencion.AtencionActualizar;

@Path("/atencion")
public interface IActualizarAtencion {
  @PUT
  @Path("/{idAtencion}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putAtencion(@PathParam("idAtencion") String idAtencion, AtencionActualizar atencionActualizar);
}