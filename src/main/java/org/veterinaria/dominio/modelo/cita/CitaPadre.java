package org.veterinaria.dominio.modelo.cita;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class CitaPadre {
  public static final String FORMATO_FECHA = "dd/MM/yyyy";

  public static Date convertirFecha(String fecha) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
    LocalDate fechaLocal = LocalDate.parse(fecha, formatter);
    return Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  public static String convertirFechaAString(Date fecha) {
    SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA);
    return formatter.format(fecha);
  }

  public boolean validarFecha(String fecha) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
    try {
      LocalDate fechaLocal = LocalDate.parse(fecha, formatter);
      return fechaLocal.isBefore(LocalDate.now());
    } catch (DateTimeParseException e) {
      return true;
    }
  }
}
