package org.veterinaria.dominio.modelo.atencion;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MongoEntity(collection = "collect-Atencion")
public class AtencionEntidad extends PanacheMongoEntity {
  private String idCita;
  private String motivo;
  private Double peso;
  private Double temperatura;
  private Integer frecuenciaRespiratoria;
  private Integer frecuenciaCardiaca;
  private String idDiagnostico;
  private String idProcedimiento;
  private String detalleDiagnostico;
  private String detalleProcedimiento;
  private Boolean cerrado;
  private Boolean borrado;
}
