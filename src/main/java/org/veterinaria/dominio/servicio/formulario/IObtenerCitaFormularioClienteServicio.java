package org.veterinaria.dominio.servicio.formulario;

import org.veterinaria.dominio.modelo.formulario.FormularioSalida;

public interface IObtenerCitaFormularioClienteServicio {
  FormularioSalida obtenerFormularioCliente(String idCliente);
}
