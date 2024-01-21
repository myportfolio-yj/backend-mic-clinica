package org.veterinaria.dominio.servicio.geolocalizacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.aplicacion.puertos.salida.geolocalizacion.IGeolocalizacionRepositorio;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionActualizar;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionCrear;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionEntidad;
import org.veterinaria.dominio.modelo.geolocalizacion.GeolocalizacionSalida;
import org.veterinaria.infraestructura.adaptador.salida.cliente.ClienteAPI;
import org.veterinaria.infraestructura.adaptador.salida.mascota.MascotaAPI;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GeolocalizacionServicio implements IGeolocalizacionServicio {
  public static final String FECHA_FORMATO = "dd/MM/yyyy";
  public static final String HORA_FORMATO = "HH:mm:ss";
  public static final String MAP_URL = "https://maps.google.com/?q=";
  private final IGeolocalizacionRepositorio repositorio;
  private final MascotaAPI mascotaAPI;

  @Inject
  public GeolocalizacionServicio(IGeolocalizacionRepositorio repositorio, @RestClient MascotaAPI mascotaAPI) {
    this.repositorio = repositorio;
    this.mascotaAPI = mascotaAPI;
  }

  @Override
  public List<GeolocalizacionSalida> obtenerGeolocalizacionPorIdMascota(String idMascota) {
    List<GeolocalizacionEntidad> geolocalizacionEntidades = repositorio.obtenerGeolocalizacionPorIdMascota(idMascota);
    SimpleDateFormat formatoFecha = new SimpleDateFormat(FECHA_FORMATO);
    SimpleDateFormat formatoHora = new SimpleDateFormat(HORA_FORMATO);
    return geolocalizacionEntidades.parallelStream().map(p -> {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(p.getFechaHora());
      calendar.add(Calendar.HOUR_OF_DAY, -5);
      Date fechaHoraMenosCinco = calendar.getTime();
      return GeolocalizacionSalida.builder()
            .id(p.id.toString())
            .mascota(mascotaAPI.getMascotaPorId(p.getIdMascota()))
            .cliente(mascotaAPI.getMascotaClientePorId(p.getIdMascota()).getClientes())
            .url(MAP_URL + p.getLatitud() + ',' + p.getLongitud())
            .telefono(p.getTelefono())
            .fecha(formatoFecha.format(p.getFechaHora()))
            .hora(formatoHora.format(fechaHoraMenosCinco))
            .build();
    }).toList();
  }

  @Override
  public List<GeolocalizacionSalida> obtenerGeolocalizacion() {
    List<GeolocalizacionEntidad> geolocalizacionEntidades = repositorio.obtenerTodosGeolocalizacion();
    SimpleDateFormat formatoFecha = new SimpleDateFormat(FECHA_FORMATO);
    SimpleDateFormat formatoHora = new SimpleDateFormat(HORA_FORMATO);
    return geolocalizacionEntidades.parallelStream().map(p -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(p.getFechaHora());
            calendar.add(Calendar.HOUR_OF_DAY, -5);
            Date fechaHoraMenosCinco = calendar.getTime();
            return GeolocalizacionSalida.builder()
                  .id(p.id.toString())
                  .mascota(mascotaAPI.getMascotaPorId(p.getIdMascota()))
                  .url(MAP_URL + p.getLatitud() + ',' + p.getLongitud())
                  .telefono(p.getTelefono())
                  .fecha(formatoFecha.format(p.getFechaHora()))
                  .hora(formatoHora.format(fechaHoraMenosCinco))
                  .build();
          })
          .toList();
  }

  @Override
  public GeolocalizacionSalida obtenerGeolocalizacionPorId(String idGeolocalizacion) {
    GeolocalizacionEntidad geolocalizacionEntidad = repositorio.obtenerGeolocalizacionPorId(idGeolocalizacion);
    SimpleDateFormat formatoFecha = new SimpleDateFormat(FECHA_FORMATO);
    SimpleDateFormat formatoHora = new SimpleDateFormat(HORA_FORMATO);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(geolocalizacionEntidad.getFechaHora());
    calendar.add(Calendar.HOUR_OF_DAY, -5);
    Date fechaHoraMenosCinco = calendar.getTime();
    return GeolocalizacionSalida.builder()
          .id(geolocalizacionEntidad.id.toString())
          .mascota(mascotaAPI.getMascotaPorId(geolocalizacionEntidad.getIdMascota()))
          .url(MAP_URL + geolocalizacionEntidad.getLatitud() + ',' + geolocalizacionEntidad.getLongitud())
          .telefono(geolocalizacionEntidad.getTelefono())
          .fecha(formatoFecha.format(geolocalizacionEntidad.getFechaHora()))
          .hora(formatoHora.format(fechaHoraMenosCinco))
          .build();
  }

  @Override
  public GeolocalizacionSalida crearGeolocalizacion(GeolocalizacionCrear geolocalizacionCrear) {
    GeolocalizacionEntidad geolocalizacionEntidad = new GeolocalizacionEntidad();
    geolocalizacionEntidad.setIdMascota(geolocalizacionCrear.getIdMascota());
    geolocalizacionEntidad.setLatitud(geolocalizacionCrear.getLatitud());
    geolocalizacionEntidad.setLongitud(geolocalizacionCrear.getLongitud());
    geolocalizacionEntidad.setTelefono(geolocalizacionCrear.getTelefono());
    geolocalizacionEntidad.setFechaHora(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
    geolocalizacionEntidad = repositorio.crearGeolocalizacion(geolocalizacionEntidad);
    return this.obtenerGeolocalizacionPorId(geolocalizacionEntidad.id.toString());
  }

  @Override
  public GeolocalizacionSalida actualizarGeolocalizacion(String idGeolocalizacion, GeolocalizacionActualizar geolocalizacionActualizar) {
    GeolocalizacionEntidad geolocalizacionEntidad = new GeolocalizacionEntidad();
    geolocalizacionEntidad.setIdMascota(geolocalizacionActualizar.getIdMascota());
    geolocalizacionEntidad.setLatitud(geolocalizacionActualizar.getLatitud());
    geolocalizacionEntidad.setLongitud(geolocalizacionActualizar.getLongitud());
    geolocalizacionEntidad.setTelefono(geolocalizacionActualizar.getTelefono());
    geolocalizacionEntidad.setFechaHora(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
    repositorio.actualizarGeolocalizacion(idGeolocalizacion, geolocalizacionEntidad);
    return this.obtenerGeolocalizacionPorId(idGeolocalizacion);
  }

  @Override
  public GeolocalizacionSalida eliminarGeolocalizacion(String idGeolocalizacion) {
    GeolocalizacionEntidad geolocalizacionEntidad = repositorio.eliminarGeolocalizacion(idGeolocalizacion);
    SimpleDateFormat formatoFecha = new SimpleDateFormat(FECHA_FORMATO);
    SimpleDateFormat formatoHora = new SimpleDateFormat(HORA_FORMATO);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(geolocalizacionEntidad.getFechaHora());
    calendar.add(Calendar.HOUR_OF_DAY, -5);
    Date fechaHoraMenosCinco = calendar.getTime();
    return GeolocalizacionSalida.builder()
          .id(geolocalizacionEntidad.id.toString())
          .mascota(mascotaAPI.getMascotaPorId(geolocalizacionEntidad.getIdMascota()))
          .url(MAP_URL + geolocalizacionEntidad.getLatitud() + ',' + geolocalizacionEntidad.getLongitud())
          .telefono(geolocalizacionEntidad.getTelefono())
          .fecha(formatoFecha.format(geolocalizacionEntidad.getFechaHora()))
          .hora(formatoHora.format(fechaHoraMenosCinco))
          .build();
  }

}
