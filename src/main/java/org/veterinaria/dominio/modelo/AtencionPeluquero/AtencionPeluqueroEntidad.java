package org.veterinaria.dominio.modelo.AtencionPeluquero;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@MongoEntity(collection = "collect-AtencionPeluquero")
public class AtencionPeluqueroEntidad extends PanacheMongoEntity {
  private ObjectId id;
  private String atencionPeluquero;
  private Boolean delete;
}
