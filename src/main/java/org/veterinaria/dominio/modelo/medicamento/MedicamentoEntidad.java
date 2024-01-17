package org.veterinaria.dominio.modelo.medicamento;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Medicamento")
public class MedicamentoEntidad extends PanacheMongoEntity {
  private String medicamento;
  private String descripcion;
  private Boolean borrado;
}
