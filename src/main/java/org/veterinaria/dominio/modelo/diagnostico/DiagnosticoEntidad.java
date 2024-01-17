package org.veterinaria.dominio.modelo.diagnostico;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Diagnostico")
public class DiagnosticoEntidad extends PanacheMongoEntity {
  private String diagnostico;
  private String detalle;
  private Boolean borrado;
}
