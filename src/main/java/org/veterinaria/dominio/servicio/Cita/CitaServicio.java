package org.veterinaria.dominio.servicio.Cita;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.aplicacion.puertos.salida.AtencionPeluquero.IAtencionPeluqueroRepositorio;
import org.veterinaria.aplicacion.puertos.salida.Cita.ICitaRepositorio;
import org.veterinaria.aplicacion.puertos.salida.TipoCita.ITipoCitaRepositorio;
import org.veterinaria.dominio.modelo.AtencionPeluquero.AtencionPeluqueroEntidad;
import org.veterinaria.dominio.modelo.Cita.CitaActualizar;
import org.veterinaria.dominio.modelo.Cita.CitaCrear;
import org.veterinaria.dominio.modelo.Cita.CitaEntidad;
import org.veterinaria.dominio.modelo.Cita.CitaSalida;
import org.veterinaria.dominio.modelo.Mascota.Mascota;
import org.veterinaria.dominio.modelo.TipoCita.TipoCitaEntidad;
import org.veterinaria.infraestructura.adaptador.salida.Mascota.MascotaAPI;

import java.util.List;

@ApplicationScoped
public class CitaServicio implements ICitaServicio {
  @Inject
  ICitaRepositorio repositorio;
  @Inject
  @RestClient
  MascotaAPI mascotaService;
  @Inject
  ITipoCitaRepositorio tipoCitaRepositorio;
  @Inject
  IAtencionPeluqueroRepositorio atencionPeluqueroRepositorio;

  @Override
  public CitaSalida crearCita(CitaCrear cita) {
    Mascota mascota = mascotaService.getMascotaPorId(cita.getIdMascota());
    if (mascota == null) return new CitaSalida();
    TipoCitaEntidad tipoCitaEntidad = tipoCitaRepositorio.obtenerTipoCitaPorId(cita.getIdTipoCita());
    if (tipoCitaEntidad == null || tipoCitaEntidad.getTipoCita() == null) return new CitaSalida();
    if (tipoCitaEntidad.getTipoCita().equals("Cita Peluqueria")) {
      cita.getAtencionesPeluqueria().forEach(p -> {
        AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(p);
      });
    }
    CitaEntidad citaEntidad = new CitaEntidad();
    citaEntidad.setIdMascota(cita.getIdMascota());
    citaEntidad.setIdTipoCita(cita.getIdTipoCita());
    citaEntidad.setAtencionesPeluqueria(cita.getAtencionesPeluqueria());
    citaEntidad.setFecha(cita.getFecha());
    citaEntidad.setTurno(cita.getTurno());
    citaEntidad.setObservaciones(cita.getObservaciones());
    citaEntidad = repositorio.crearCita(citaEntidad);
    return this.obtenerCitaPorId(citaEntidad.getId().toString());
  }

  @Override
  public CitaSalida obtenerCitaPorId(String idCita) {
    CitaEntidad citaEntidad = repositorio.obtenerCitaPorId(idCita);
    return getCitaSalida(citaEntidad);
  }

  @Override
  public CitaSalida actualizarCita(String idCita, CitaActualizar citaActualizar) {
    Mascota mascota = mascotaService.getMascotaPorId(citaActualizar.getIdMascota());
    if (mascota == null) return new CitaSalida();
    TipoCitaEntidad tipoCitaEntidad = tipoCitaRepositorio.obtenerTipoCitaPorId(citaActualizar.getIdTipoCita());
    if (tipoCitaEntidad == null || tipoCitaEntidad.getTipoCita() == null) return new CitaSalida();
    if (tipoCitaEntidad.getTipoCita().equals("Cita Peluqueria")) {
      citaActualizar.getAtencionesPeluqueria().forEach(p -> {
        AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(p);
      });
    }
    CitaEntidad citaEntidad = new CitaEntidad();
    citaEntidad.setIdMascota(citaActualizar.getIdMascota());
    citaEntidad.setIdTipoCita(citaActualizar.getIdTipoCita());
    citaEntidad.setAtencionesPeluqueria(citaActualizar.getAtencionesPeluqueria());
    citaEntidad.setFecha(citaActualizar.getFecha());
    citaEntidad.setTurno(citaActualizar.getTurno());
    citaEntidad.setObservaciones(citaActualizar.getObservaciones());
    repositorio.actualizarCita(idCita, citaEntidad);
    return this.obtenerCitaPorId(idCita);
  }

  @Override
  public CitaSalida eliminarCita(String idCita) {
    CitaEntidad citaEntidad = repositorio.eliminarCita(idCita);
    return getCitaSalida(citaEntidad);
  }

  @Override
  public List<CitaSalida> obtenerCita() {
    return repositorio.obtenerTodosCita().parallelStream().map(this::getCitaSalida).toList();
  }

  private CitaSalida getCitaSalida(CitaEntidad citaEntidad) {
    return CitaSalida.builder()
          .id(citaEntidad.getId().toString())
          .idMascota(citaEntidad.getIdMascota())
          .nombreMascota(mascotaService.getMascotaPorId(citaEntidad.getIdMascota()).getNombre())
          .idTipoCita(citaEntidad.getIdTipoCita())
          .tipoCita(tipoCitaRepositorio.obtenerTipoCitaPorId(citaEntidad.getIdTipoCita()).getTipoCita())
          .atencionesPeluqueria(
                tipoCitaRepositorio.obtenerTipoCitaPorId(citaEntidad.getIdTipoCita()).getTipoCita().equals("Cita Peluqueria") ?
                      citaEntidad.getAtencionesPeluqueria().parallelStream()
                            .map(q -> {
                              AtencionPeluqueroEntidad atencionPeluqueroEntidad = atencionPeluqueroRepositorio.obtenerAtencionPeluqueroPorId(q);
                              return atencionPeluqueroEntidad.getAtencionPeluquero();
                            })
                            .toList()
                      : null
          )
          .fecha(citaEntidad.getFecha())
          .turno(citaEntidad.getTurno())
          .observaciones(citaEntidad.getObservaciones())
          .build();
  }
}
