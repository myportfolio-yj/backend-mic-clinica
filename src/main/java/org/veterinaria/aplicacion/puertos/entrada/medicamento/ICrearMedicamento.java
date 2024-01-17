package org.veterinaria.aplicacion.puertos.entrada.medicamento;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoCrear;

@Path("/medicamento")
public interface ICrearMedicamento {
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response postMedicamento(MedicamentoCrear medicamentoCrear);
}
