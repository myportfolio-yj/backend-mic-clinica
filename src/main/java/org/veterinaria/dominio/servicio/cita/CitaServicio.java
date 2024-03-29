package org.veterinaria.dominio.servicio.cita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.aplicacion.puertos.salida.atencionpeluquero.IAtencionPeluqueroRepositorio;
import org.veterinaria.aplicacion.puertos.salida.cita.ICitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.tipocita.ITipoCitaRepositorio;
import org.veterinaria.dominio.FechaInvalidaException;
import org.veterinaria.dominio.modelo.atencionpeluquero.AtencionPeluqueroEntidad;
import org.veterinaria.dominio.modelo.cita.*;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaEntidad;
import org.veterinaria.infraestructura.adaptador.salida.cliente.ClienteAPI;
import org.veterinaria.infraestructura.adaptador.salida.mascota.MascotaAPI;

import java.util.List;

@ApplicationScoped
public class CitaServicio implements ICitaServicio {
  public static final String FECHA_INVALIDA = "La fecha no es valida";
  public static final String CITA_PELUQUERIA = "Cita Peluqueria";
  private final MascotaAPI mascotaService;
  private final ClienteAPI clienteAPI;
  private final ICitaRepositorio repositorio;
  private final ITipoCitaRepositorio tipoCitaRepositorio;
  private final IAtencionPeluqueroRepositorio atencionPeluqueroRepositorio;

  @Inject
  public CitaServicio(@RestClient MascotaAPI mascotaService, @RestClient ClienteAPI clienteAPI, ICitaRepositorio repositorio, ITipoCitaRepositorio tipoCitaRepositorio, IAtencionPeluqueroRepositorio atencionPeluqueroRepositorio) {
    this.mascotaService = mascotaService;
    this.clienteAPI = clienteAPI;
    this.repositorio = repositorio;
    this.tipoCitaRepositorio = tipoCitaRepositorio;
    this.atencionPeluqueroRepositorio = atencionPeluqueroRepositorio;
  }

  @Override
  public List<CitaSalida> obtenerCitaHistorial() {
    return repositorio.obtenerTodosCitaAtendidas().parallelStream().map(this::getCitaSalida).toList();
  }

  @Override
  public List<CitaSalida> obtenerCita() {
    return repositorio.obtenerTodosCita().parallelStream().map(this::getCitaSalida).toList();
  }

  @Override
  public CitaSalida obtenerCitaPorId(String idCita) {
    CitaEntidad citaEntidad = repositorio.obtenerCitaPorId(idCita);
    return getCitaSalida(citaEntidad);
  }

  @Override
  public CitaSalida crearCita(CitaCrear cita) {
    if (cita.validarFecha(cita.getFecha())) {
      throw new FechaInvalidaException(FECHA_INVALIDA);
    }
    MascotaMinSalida mascota = mascotaService.getMascotaPorId(cita.getIdMascota());
    if (mascota == null) return new CitaSalida();
    TipoCitaEntidad tipoCitaEntidad = tipoCitaRepositorio.obtenerTipoCitaPorId(cita.getIdTipoCita());
    if (tipoCitaEntidad == null || tipoCitaEntidad.getTipoCita() == null) return new CitaSalida();
    if (tipoCitaEntidad.getTipoCita().equals(CITA_PELUQUERIA)) {
      cita.getAtencionesPeluqueria().forEach(p -> {
        AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(p);
      });
    }
    CitaEntidad citaEntidad = crearCitaEntidad(cita.getIdCliente(), cita.getIdMascota(), cita.getIdTipoCita(), cita.getAtencionesPeluqueria(), cita.getFecha(), cita.getTurno(), cita.getObservaciones());
    citaEntidad = repositorio.crearCita(citaEntidad);
    return this.obtenerCitaPorId(citaEntidad.id.toString());
  }

  @Override
  public CitaSalida actualizarCita(String idCita, CitaActualizar citaActualizar) {
    if (citaActualizar.validarFecha(citaActualizar.getFecha())) {
      throw new FechaInvalidaException(FECHA_INVALIDA);
    }
    MascotaMinSalida mascota = mascotaService.getMascotaPorId(citaActualizar.getIdMascota());
    if (mascota == null) return new CitaSalida();
    TipoCitaEntidad tipoCitaEntidad = tipoCitaRepositorio.obtenerTipoCitaPorId(citaActualizar.getIdTipoCita());
    if (tipoCitaEntidad == null || tipoCitaEntidad.getTipoCita() == null) return new CitaSalida();
    if (tipoCitaEntidad.getTipoCita().equals(CITA_PELUQUERIA)) {
      citaActualizar.getAtencionesPeluqueria().forEach(p -> {
        AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(p);
      });
    }
    CitaEntidad citaEntidad = crearCitaEntidad(citaActualizar.getIdCliente(), citaActualizar.getIdMascota(), citaActualizar.getIdTipoCita(), citaActualizar.getAtencionesPeluqueria(), citaActualizar.getFecha(), citaActualizar.getTurno(), citaActualizar.getObservaciones());
    repositorio.actualizarCita(idCita, citaEntidad);
    return this.obtenerCitaPorId(idCita);
  }

  @Override
  public CitaSalida eliminarCita(String idCita) {
    CitaEntidad citaEntidad = repositorio.eliminarCita(idCita);
    return getCitaSalida(citaEntidad);
  }

  private CitaSalida getCitaSalida(CitaEntidad citaEntidad) {
    return CitaSalida.builder()
          .id(citaEntidad.id.toString())
          .cliente(clienteAPI.getClienteMinPorId(citaEntidad.getIdCliente()))
          .idMascota(citaEntidad.getIdMascota())
          .nombreMascota(mascotaService.getMascotaPorId(citaEntidad.getIdMascota()).getNombre())
          .mascota(mascotaService.getMascotaPorId(citaEntidad.getIdMascota()))
          .idTipoCita(citaEntidad.getIdTipoCita())
          .tipoCita(tipoCitaRepositorio.obtenerTipoCitaPorId(citaEntidad.getIdTipoCita()).getTipoCita())
          .atencionesPeluqueria(
                tipoCitaRepositorio.obtenerTipoCitaPorId(citaEntidad.getIdTipoCita()).getTipoCita().equals(CITA_PELUQUERIA) ?
                      citaEntidad.getAtencionesPeluqueria().parallelStream()
                            .map(q -> {
                              AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(q);
                              return atencionPeluqueroEntidad.getAtencionPeluquero();
                            })
                            .toList()
                      : null
          )
          .fecha(CitaPadre.convertirFechaAString(citaEntidad.getFecha()))
          .turno(citaEntidad.getTurno())
          .observaciones(citaEntidad.getObservaciones())
          .checkIn(citaEntidad.getCheckIn())
          .idAtencion((citaEntidad.getIdAtencion()))
          .recetas((citaEntidad.getRecetas()))
          .build();
  }

  private CitaEntidad crearCitaEntidad(String idCliente, String idMascota, String idTipoCita, List<String> atencionesPeluqueria, String fecha, String turno, String observaciones) {
    CitaEntidad citaEntidad = new CitaEntidad();
    citaEntidad.setIdCliente(idCliente);
    citaEntidad.setIdMascota(idMascota);
    citaEntidad.setIdTipoCita(idTipoCita);
    citaEntidad.setAtencionesPeluqueria(atencionesPeluqueria);
    citaEntidad.setFecha(CitaPadre.convertirFecha(fecha));
    citaEntidad.setTurno(turno);
    citaEntidad.setObservaciones(observaciones);
    citaEntidad.setIdAtencion(null);
    citaEntidad.setRecetas(null);
    return citaEntidad;
  }

  @Override
  public List<CitaSalida> obtenerCitasVigentesPorIdCliente(String idCliente) {
    return repositorio.obtenerCitasVigentesPorIdCliente(idCliente).parallelStream().map(this::getCitaSalida).toList();
  }

  @Override
  public List<CitaSalida> obtenerCitasVigentes() {
    return repositorio.obtenerCitasVigentes().parallelStream().map(this::getCitaSalida).toList();
  }

  @Override
  public CitaSalida checkIn(String idCita) {
    CitaSalida citaSalida = this.obtenerCitaPorId(idCita);
    CitaEntidad citaEntidad = crearCitaEntidad(citaSalida.getCliente().getId(), citaSalida.getIdMascota(), citaSalida.getIdTipoCita(), citaSalida.getAtencionesPeluqueria(), citaSalida.getFecha(), citaSalida.getTurno(), citaSalida.getObservaciones());
    citaEntidad.setCheckIn(true);
    repositorio.actualizarCita(idCita, citaEntidad);
    return this.obtenerCitaPorId(idCita);
  }
}
