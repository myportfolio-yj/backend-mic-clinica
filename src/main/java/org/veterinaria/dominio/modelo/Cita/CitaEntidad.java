package org.veterinaria.dominio.modelo.Cita;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "collect-Cita")
public class CitaEntidad extends PanacheMongoEntity {
  private ObjectId id;
  private String idCliente;
  private String idMascota;
  private String idTipoCita;
  private List<String> atencionesPeluqueria;
  private Date fecha;
  private String turno;
  private String observaciones;
  private Boolean delete;
}
