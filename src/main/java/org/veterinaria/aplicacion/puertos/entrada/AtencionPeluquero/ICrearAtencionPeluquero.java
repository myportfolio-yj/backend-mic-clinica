package org.veterinaria.aplicacion.puertos.entrada.AtencionPeluquero;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroCrear;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaCrear;

@Path("/atencionpeluquero")
public interface ICrearAtencionPeluquero {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postAtencionPeluquero(AtencionPeluqueroCrear atencionPeluqueroCrear);
}
