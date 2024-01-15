package org.veterinaria.dominio.modelo.atencionpeluquero;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-AtencionPeluquero")
public class AtencionPeluqueroEntidad extends PanacheMongoEntity {
  private String atencionPeluquero;
  private Boolean delete;
}
