package com.dbsm.models;

/**
 * Telefono
 */
public class Telefono {

  private Integer ID_TELEFONO;
  private Integer ID_TIPO_TELEFONO;
  private Integer ID_COMPANIA;
  private Integer TELEFONO;


  public Telefono() {
  }

  public Telefono(Integer ID_TELEFONO, Integer ID_TIPO_TELEFONO, Integer ID_COMPANIA, Integer TELEFONO) {
    this.ID_TELEFONO = ID_TELEFONO;
    this.ID_TIPO_TELEFONO = ID_TIPO_TELEFONO;
    this.ID_COMPANIA = ID_COMPANIA;
    this.TELEFONO = TELEFONO;
  }

  public Integer getID_TELEFONO() {
    return this.ID_TELEFONO;
  }

  public void setID_TELEFONO(Integer ID_TELEFONO) {
    this.ID_TELEFONO = ID_TELEFONO;
  }

  public Integer getID_TIPO_TELEFONO() {
    return this.ID_TIPO_TELEFONO;
  }

  public void setID_TIPO_TELEFONO(Integer ID_TIPO_TELEFONO) {
    this.ID_TIPO_TELEFONO = ID_TIPO_TELEFONO;
  }

  public Integer getID_COMPANIA() {
    return this.ID_COMPANIA;
  }

  public void setID_COMPANIA(Integer ID_COMPANIA) {
    this.ID_COMPANIA = ID_COMPANIA;
  }

  public Integer getTELEFONO() {
    return this.TELEFONO;
  }

  public void setTELEFONO(Integer TELEFONO) {
    this.TELEFONO = TELEFONO;
  }

  public Telefono ID_TELEFONO(Integer ID_TELEFONO) {
    this.ID_TELEFONO = ID_TELEFONO;
    return this;
  }

  public Telefono ID_TIPO_TELEFONO(Integer ID_TIPO_TELEFONO) {
    this.ID_TIPO_TELEFONO = ID_TIPO_TELEFONO;
    return this;
  }

  public Telefono ID_COMPANIA(Integer ID_COMPANIA) {
    this.ID_COMPANIA = ID_COMPANIA;
    return this;
  }

  public Telefono TELEFONO(Integer TELEFONO) {
    this.TELEFONO = TELEFONO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_TELEFONO='" + getID_TELEFONO() + "'" +
      ", ID_TIPO_TELEFONO='" + getID_TIPO_TELEFONO() + "'" +
      ", ID_COMPANIA='" + getID_COMPANIA() + "'" +
      ", TELEFONO='" + getTELEFONO() + "'" +
      "}";
  }

}