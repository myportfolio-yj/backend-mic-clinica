package org.veterinaria.infraestructura.adaptador.salida.veterinario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.veterinario.VeterinarioSalida;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface VeterinarioAPI {
  @GET
  @Path("/veterinario")
  @Produces(MediaType.APPLICATION_JSON)
  List<VeterinarioSalida> getVeterinarios();
}
