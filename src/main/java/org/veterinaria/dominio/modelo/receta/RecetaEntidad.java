package org.veterinaria.dominio.modelo.receta;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Receta")
public class RecetaEntidad extends PanacheMongoEntity {
  private String idCita;
  private String idMedicamento;
  private Double cantidad;
  private Double dosis;
  private String indicaciones;
  private Boolean borrado;
}
