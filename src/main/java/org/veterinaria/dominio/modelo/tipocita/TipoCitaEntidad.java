package org.veterinaria.dominio.modelo.tipocita;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-TipoCita")
public class TipoCitaEntidad extends PanacheMongoEntity {
  private String tipoCita;
  private Boolean delete;
}
