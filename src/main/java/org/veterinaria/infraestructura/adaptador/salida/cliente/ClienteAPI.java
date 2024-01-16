package org.veterinaria.infraestructura.adaptador.salida.cliente;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.cliente.ClienteSalida;

@Path("/")
@RegisterRestClient
public interface ClienteAPI {
  @GET
  @Path("/cliente/{idCliente}")
  @Produces(MediaType.APPLICATION_JSON)
  ClienteSalida getClientePorId(@PathParam("idCliente") String idCliente);
}
