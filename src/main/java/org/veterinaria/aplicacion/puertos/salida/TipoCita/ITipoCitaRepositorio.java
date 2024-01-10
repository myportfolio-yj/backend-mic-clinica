package org.veterinaria.aplicacion.puertos.salida.TipoCita;

import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;

import java.util.List;

public interface ITipoCitaRepositorio {
  List<TipoCitaEntidad> obtenerTodosTipoCita();

  TipoCitaEntidad obtenerTipoCitaPorId(String idTipoCita);

  TipoCitaEntidad crearTipoCita(TipoCitaEntidad tipoCita);

  TipoCitaEntidad actualizarTipoCita(String idTipoCita, TipoCitaEntidad tipoCita);

  TipoCitaEntidad eliminarTipoCita(String idTipoCita);
}
