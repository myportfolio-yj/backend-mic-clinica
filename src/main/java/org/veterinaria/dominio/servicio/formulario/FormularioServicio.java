package org.veterinaria.dominio.servicio.formulario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.veterinaria.dominio.modelo.formulario.*;
import org.veterinaria.dominio.modelo.mascota.MascotaMinSalida;
import org.veterinaria.dominio.modelo.mascota.MascotaSalida;
import org.veterinaria.dominio.modelo.tipocita.TipoCitaSalida;
import org.veterinaria.dominio.servicio.atencionpeluquero.IAtencionPeluqueroServicio;
import org.veterinaria.dominio.servicio.tipocita.ITipoCitaServicio;
import org.veterinaria.infraestructura.adaptador.salida.cliente.ClienteAPI;
import org.veterinaria.infraestructura.adaptador.salida.mascota.MascotaAPI;
import org.veterinaria.infraestructura.adaptador.salida.peluquero.PeluqueroAPI;
import org.veterinaria.infraestructura.adaptador.salida.veterinario.VeterinarioAPI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class FormularioServicio implements IFormularioServicio {
  @Inject
  @RestClient
  PeluqueroAPI peluqueroAPI;
  @Inject
  @RestClient
  VeterinarioAPI veterinarioAPI;
  @Inject
  @RestClient
  MascotaAPI mascotaAPI;
  @Inject
  ITipoCitaServicio tipoCitaServicio;
  @Inject
  IAtencionPeluqueroServicio atencionPeluqueroServicio;
  @Inject
  @RestClient
  ClienteAPI clienteAPI;

  private static List<String> getIntervalosTurnos(String... intervalos) {
    return Arrays.asList(intervalos);
  }

  private <T, R> List<R> setConfig(Supplier<List<T>> apiSupplier, Function<T, R> reservaBuilder) {
    List<T> apiResponse = apiSupplier.get();
    return apiResponse.parallelStream().map(reservaBuilder).toList();
  }

  private List<Turno2> setConfig(List<String> intervalosTurnos) {
    return IntStream.rangeClosed(1, 6)
          .mapToObj(i -> agregarTurnos(i, intervalosTurnos))
          .collect(Collectors.toList());
  }

  private Turno2 agregarTurnos(int dias, List<String> intervalosTurnos) {
    LocalDate fecha = LocalDate.now().plusDays(dias);
    DayOfWeek diaDeLaSemana = fecha.getDayOfWeek();
    String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    return Turno2.builder()
          .fecha(fechaFormateada)
          .dia(diaDeLaSemana.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es")))
          .turnos(intervalosTurnos)
          .build();
  }

  private List<ReservaVeterinario> crearReservasVeterinario(List<String> intervalosTurnos) {
    return setConfig(veterinarioAPI::getVeterinarios,
          p -> ReservaVeterinario.builder().verinario(p).turnos(setConfig(intervalosTurnos)).build());
  }

  private List<ReservaPeluquero> crearReservasPeluquero(List<String> intervalosTurnos) {
    return setConfig(peluqueroAPI::getPeluquero,
          p -> ReservaPeluquero.builder().peluquero(p).turnos(setConfig(intervalosTurnos)).build());
  }

  private List<ReservaPeluquero> setPeluquero() {
    return crearReservasPeluquero(getIntervalosTurnos("09:00-09:30", "09:30-10:00", "10:00-10:30", "10:30-11:00", "11:00-11:30", "11:30-12:00", "12:00-12:30", "12:30-13:00", "13:00-13:30", "13:30-14:00", "14:00-14:30", "14:30-15:00", "15:00-15:30", "15:30-16:00", "16:00-16:30", "16:30-17:00", "17:00-17:30", "17:30-18:00"));
  }

  private List<ReservaVeterinario> setVeterinario() {
    return crearReservasVeterinario(getIntervalosTurnos("09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00"));
  }

  private MascotaMinMinSalida crearMascotaMinMinSalida(MascotaMinSalida p) {
    return MascotaMinMinSalida.builder()
          .id(p.getId())
          .codIdentificacion(p.getCodIdentificacion())
          .nombre(p.getNombre())
          .apellido(p.getApellido())
          .build();
  }

  private MascotaMinMinSalida crearMascotaMinMinSalida(MascotaSalida p) {
    return MascotaMinMinSalida.builder()
          .id(p.getId())
          .codIdentificacion(p.getCodIdentificacion())
          .nombre(p.getNombre())
          .apellido(p.getApellido())
          .build();
  }

  private TipoCitaListaSalida crearTipoCitaListaSalida(TipoCitaSalida p) {
    return TipoCitaListaSalida.builder()
          .id(p.getId())
          .tipoCita(p.getTipoCita())
          .reservasPeluquero((p.getTipoCita().equals("Cita Peluqueria")) ? setPeluquero() : null)
          .reservasVeterinario((p.getTipoCita().equals("Cita Veterinaria")) ? setVeterinario() : null)
          .build();
  }

  @Override
  public FormularioSalida obtenerFormulario() {
    return FormularioSalida.builder()
          .mascotas(mascotaAPI.getMascotas().parallelStream().map(this::crearMascotaMinMinSalida).toList())
          .tiposCita(tipoCitaServicio.obtenerTipoCita().parallelStream().map(this::crearTipoCitaListaSalida).toList())
          .atencionesPeluqueria(atencionPeluqueroServicio.obtenerAtencionPeluquero())
          .build();
  }

  @Override
  public FormularioSalida obtenerFormularioCliente(String idCliente) {
    return FormularioSalida.builder()
          .mascotas(clienteAPI.getClientePorId(idCliente).getMascotas().parallelStream().map(this::crearMascotaMinMinSalida).toList())
          .tiposCita(tipoCitaServicio.obtenerTipoCita().parallelStream().map(this::crearTipoCitaListaSalida).toList())
          .atencionesPeluqueria(atencionPeluqueroServicio.obtenerAtencionPeluquero())
          .build();
  }
}