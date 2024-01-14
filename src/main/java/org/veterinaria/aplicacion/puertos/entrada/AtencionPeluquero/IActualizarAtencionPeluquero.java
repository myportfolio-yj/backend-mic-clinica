package org.veterinaria.aplicacion.puertos.entrada.AtencionPeluquero;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroActualizar;

@Path("/atencionpeluquero")
public interface IActualizarAtencionPeluquero {
  @PUT
  @Path("/{idAtencionPeluquero}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putAtencionPeluquero(@PathParam("idAtencionPeluquero") String idAtencionPeluquero, AtencionPeluqueroActualizar atencionPeluqueroActualizar);
}