package org.veterinaria.dominio.modelo.Turno;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@MongoEntity(collection = "collect-Turno")
public class TurnoEntidad extends PanacheMongoEntity {
  private ObjectId id;
  private String idTipoCita;
  private String turno;
  private String diaSemana;
  private Integer valor;
  private Boolean borrado;
}
