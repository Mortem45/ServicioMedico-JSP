package com.dbsm.models;

import java.util.Date;

/**
 * Seguro
 */
public class Seguro {

  private Integer ID_SEGURO;
  private Integer ID_TIPO_SEGURO;
  private String SEGURO;
  private Date FECHA_REGISTRO;
  private Date VIGENCIA_SEGURO;


  public Seguro() {
  }

  public Seguro(Integer ID_SEGURO, Integer ID_TIPO_SEGURO, String SEGURO, Date FECHA_REGISTRO, Date VIGENCIA_SEGURO) {
    this.ID_SEGURO = ID_SEGURO;
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
    this.SEGURO = SEGURO;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    this.VIGENCIA_SEGURO = VIGENCIA_SEGURO;
  }

  public Integer getID_SEGURO() {
    return this.ID_SEGURO;
  }

  public void setID_SEGURO(Integer ID_SEGURO) {
    this.ID_SEGURO = ID_SEGURO;
  }

  public Integer getID_TIPO_SEGURO() {
    return this.ID_TIPO_SEGURO;
  }

  public void setID_TIPO_SEGURO(Integer ID_TIPO_SEGURO) {
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
  }

  public String getSEGURO() {
    return this.SEGURO;
  }

  public void setSEGURO(String SEGURO) {
    this.SEGURO = SEGURO;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Date getVIGENCIA_SEGURO() {
    return this.VIGENCIA_SEGURO;
  }

  public void setVIGENCIA_SEGURO(Date VIGENCIA_SEGURO) {
    this.VIGENCIA_SEGURO = VIGENCIA_SEGURO;
  }

  public Seguro ID_SEGURO(Integer ID_SEGURO) {
    this.ID_SEGURO = ID_SEGURO;
    return this;
  }

  public Seguro ID_TIPO_SEGURO(Integer ID_TIPO_SEGURO) {
    this.ID_TIPO_SEGURO = ID_TIPO_SEGURO;
    return this;
  }

  public Seguro SEGURO(String SEGURO) {
    this.SEGURO = SEGURO;
    return this;
  }

  public Seguro FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  public Seguro VIGENCIA_SEGURO(Date VIGENCIA_SEGURO) {
    this.VIGENCIA_SEGURO = VIGENCIA_SEGURO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_SEGURO='" + getID_SEGURO() + "'" +
      ", ID_TIPO_SEGURO='" + getID_TIPO_SEGURO() + "'" +
      ", SEGURO='" + getSEGURO() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      ", VIGENCIA_SEGURO='" + getVIGENCIA_SEGURO() + "'" +
      "}";
  }

}