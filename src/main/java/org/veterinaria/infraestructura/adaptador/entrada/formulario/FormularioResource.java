package org.veterinaria.infraestructura.adaptador.entrada.formulario;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.veterinaria.aplicacion.puertos.entrada.formulario.IFormularioResource;
import org.veterinaria.dominio.servicio.formulario.IFormularioServicio;

public class FormularioResource implements IFormularioResource {
  @Inject
  IFormularioServicio formularioServicio;

  @Override
  public Response getFormulario() {
    return Response.ok(formularioServicio.obtenerFormulario()).build();
  }

  @Override
  public Response getFormularioCliente(String idCita) {
    return Response.ok(formularioServicio.obtenerFormularioCliente(idCita)).build();
  }
}
