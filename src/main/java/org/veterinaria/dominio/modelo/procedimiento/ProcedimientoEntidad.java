package org.veterinaria.dominio.modelo.procedimiento;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Procedimiento")
public class ProcedimientoEntidad extends PanacheMongoEntity {
  private String procedimiento;
  private String descripcion;
  private Boolean borrado;
}
