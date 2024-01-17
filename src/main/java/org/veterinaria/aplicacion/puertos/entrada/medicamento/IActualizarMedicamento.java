package org.veterinaria.aplicacion.puertos.entrada.medicamento;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoActualizar;

@Path("/medicamento")
public interface IActualizarMedicamento {
  @PUT
  @Path("/{idMedicamento}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response putMedicamento(@PathParam("idMedicamento") String idMedicamento, MedicamentoActualizar medicamentoActualizar);
}