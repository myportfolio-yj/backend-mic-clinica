package org.veterinaria.dominio.modelo.TipoCita;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@MongoEntity(collection = "collect-TipoCita")
public class TipoCitaEntidad extends PanacheMongoEntity {
  private ObjectId id;
  private String tipoCita;
  private Boolean delete;
}
