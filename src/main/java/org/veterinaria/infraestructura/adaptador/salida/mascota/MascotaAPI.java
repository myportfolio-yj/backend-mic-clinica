package org.veterinaria.infraestructura.adaptador.salida.mascota;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.veterinaria.dominio.modelo.geolocalizacion.MascotaMinMinSalida;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;

import java.util.List;

@Path("/")
@RegisterRestClient
public interface MascotaAPI {

  @GET
  @Path("/mascota")
  @Produces(MediaType.APPLICATION_JSON)
  List<MascotaMinSalida> getMascotas();

  @GET
  @Path("/mascota/{idMascota}")
  @Produces(MediaType.APPLICATION_JSON)
  MascotaMinSalida getMascotaPorId(@PathParam("idMascota") String idMascota);

  @GET
  @Path("/mascota/{idMascota}")
  @Produces(MediaType.APPLICATION_JSON)
  MascotaMinMinSalida getMascotaClientePorId(@PathParam("idMascota") String idMascota);
}
