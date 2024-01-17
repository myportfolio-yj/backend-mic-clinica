package org.veterinaria.dominio.modelo.geolocalizacion;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MongoEntity(collection = "collect-Geolocalizacion")
public class GeolocalizacionEntidad extends PanacheMongoEntity {
  private String idMascota;
  private String latitud;
  private String longitud;
  private String telefono;
  private Date fechaHora;
  private Boolean borrado;
}
