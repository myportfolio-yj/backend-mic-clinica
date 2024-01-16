package org.veterinaria.infraestructura.adaptador.salida.peluquero;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.peluquero.PeluqueroSalida;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface PeluqueroAPI {
  @GET
  @Path("/peluquero")
  @Produces(MediaType.APPLICATION_JSON)
  List<PeluqueroSalida> getPeluquero();
}
