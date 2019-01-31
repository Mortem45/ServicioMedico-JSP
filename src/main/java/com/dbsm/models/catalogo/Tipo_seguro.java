package com.dbsm.models.catalogo;

/**
 * Tipo_seguro
 */
public class Tipo_seguro {

  private Integer ID_TIPO_SEGURO;
  private String TIPO_SEGURO;

  public Tipo_seguro() {
  }

  public Tipo_seguro(Integer ID_TIPO_SEGURO, String TIPO_SEGURO) {
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
    this.TIPO_SEGURO = TIPO_SEGURO;
  }

  public Integer getID_TIPO_SEGURO() {
    return this.ID_TIPO_SEGURO;
  }

  public void setID_TIPO_SEGURO(Integer ID_TIPO_SEGURO) {
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
  }

  public String getTIPO_SEGURO() {
    return this.TIPO_SEGURO;
  }

  public void setTIPO_SEGURO(String TIPO_SEGURO) {
    this.TIPO_SEGURO = TIPO_SEGURO;
  }

  public Tipo_seguro ID_TIPO_SEGURO(Integer ID_TIPO_SEGURO) {
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
    return this;
  }

  public Tipo_seguro TIPO_SEGURO(String TIPO_SEGURO) {
    this.TIPO_SEGURO = TIPO_SEGURO;
    return this;
  }
  
  @Override
  public String toString() {
    return "{" +
      " ID_TIPO_SEGURO='" + getID_TIPO_SEGURO() + "'" +
      ", TIPO_SEGURO='" + getTIPO_SEGURO() + "'" +
      "}";
  }

}