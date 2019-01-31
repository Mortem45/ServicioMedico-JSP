package com.dbsm.models;

/**
 * Resultados_laboratorio
 */
public class Resultados_laboratorio {

  private Integer ID_EXAMEN;
  private Integer ID_LABORATORISTA;
  private String RESULTADO;

  public Resultados_laboratorio() {
  }

  public Resultados_laboratorio(Integer ID_EXAMEN, Integer ID_LABORATORISTA, String RESULTADO) {
    this.ID_EXAMEN = ID_EXAMEN;
    this.ID_LABORATORISTA = ID_LABORATORISTA;
    this.RESULTADO = RESULTADO;
  }

  public Integer getID_EXAMEN() {
    return this.ID_EXAMEN;
  }

  public void setID_EXAMEN(Integer ID_EXAMEN) {
    this.ID_EXAMEN = ID_EXAMEN;
  }

  public Integer getID_LABORATORISTA() {
    return this.ID_LABORATORISTA;
  }

  public void setID_LABORATORISTA(Integer ID_LABORATORISTA) {
    this.ID_LABORATORISTA = ID_LABORATORISTA;
  }

  public String getRESULTADO() {
    return this.RESULTADO;
  }

  public void setRESULTADO(String RESULTADO) {
    this.RESULTADO = RESULTADO;
  }

  public Resultados_laboratorio ID_EXAMEN(Integer ID_EXAMEN) {
    this.ID_EXAMEN = ID_EXAMEN;
    return this;
  }

  public Resultados_laboratorio ID_LABORATORISTA(Integer ID_LABORATORISTA) {
    this.ID_LABORATORISTA = ID_LABORATORISTA;
    return this;
  }

  public Resultados_laboratorio RESULTADO(String RESULTADO) {
    this.RESULTADO = RESULTADO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_EXAMEN='" + getID_EXAMEN() + "'" +
      ", ID_LABORATORISTA='" + getID_LABORATORISTA() + "'" +
      ", RESULTADO='" + getRESULTADO() + "'" +
      "}";
  }

}