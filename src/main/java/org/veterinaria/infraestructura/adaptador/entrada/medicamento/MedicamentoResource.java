package org.veterinaria.infraestructura.adaptador.entrada.medicamento;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.medicamento.IMedicamentoResource;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoActualizar;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoCrear;
import org.veterinaria.dominio.modelo.medicamento.MedicamentoSalida;
import org.veterinaria.dominio.servicio.medicamento.IMedicamentoServicio;

public class MedicamentoResource implements IMedicamentoResource {
  private final IMedicamentoServicio servicio;

  @Inject
  public MedicamentoResource(IMedicamentoServicio servicio) {
    this.servicio = servicio;
  }

  @Override
  public Response postMedicamento(MedicamentoCrear medicamentoCrear) {
    MedicamentoSalida medicamentoSalida = servicio.crearMedicamento(medicamentoCrear);
    return Response.status(Response.Status.CREATED).entity(medicamentoSalida).build();
  }

  @Override
  public Response putMedicamento(String idMedicamento, MedicamentoActualizar medicamentoActualizar) {
    MedicamentoSalida medicamentoSalida = servicio.actualizarMedicamento(idMedicamento, medicamentoActualizar);
    return Response.ok(medicamentoSalida).build();
  }

  @Override
  public Response deleteMedicamento(String idMedicamento) {
    MedicamentoSalida medicamentoSalida = servicio.eliminarMedicamento(idMedicamento);
    return Response.status(Response.Status.CREATED).entity(medicamentoSalida).build();
  }

  @Override
  public Response getMedicamento() {
    return Response.ok(servicio.obtenerMedicamento()).build();
  }

  @Override
  public Response getMedicamentoPorId(String idMedicamento) {
    return Response.ok(servicio.obtenerMedicamentoPorId(idMedicamento)).build();
  }
}
