package com.dbsm.models;

import java.util.Date;

/**
 * Enfermedad
 */
public class Enfermedad {

  private Integer ID_ENFERMEDAD;
  private Integer ID_TIPO_ENFERMEDAD;
  private String ENFERMEDAD;
  private String DESCRIPCION;
  private String SOLUCION;
  private Date FECHA_REGISTRO;


  public Enfermedad() {
  }

  public Enfermedad(Integer ID_ENFERMEDAD, Integer ID_TIPO_ENFERMEDAD, String ENFERMEDAD, String DESCRIPCION, String SOLUCION, Date FECHA_REGISTRO) {
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
    this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
    this.ENFERMEDAD = ENFERMEDAD;
    this.DESCRIPCION = DESCRIPCION;
    this.SOLUCION = SOLUCION;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Integer getID_ENFERMEDAD() {
    return this.ID_ENFERMEDAD;
  }

  public void setID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
  }

  public Integer getID_TIPO_ENFERMEDAD() {
    return this.ID_TIPO_ENFERMEDAD;
  }

  public void setID_TIPO_ENFERMEDAD(Integer ID_TIPO_ENFERMEDAD) {
    this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
  }

  public String getENFERMEDAD() {
    return this.ENFERMEDAD;
  }

  public void setENFERMEDAD(String ENFERMEDAD) {
    this.ENFERMEDAD = ENFERMEDAD;
  }

  public String getDESCRIPCION() {
    return this.DESCRIPCION;
  }

  public void setDESCRIPCION(String DESCRIPCION) {
    this.DESCRIPCION = DESCRIPCION;
  }

  public String getSOLUCION() {
    return this.SOLUCION;
  }

  public void setSOLUCION(String SOLUCION) {
    this.SOLUCION = SOLUCION;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Enfermedad ID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
    return this;
  }

  public Enfermedad ID_TIPO_ENFERMEDAD(Integer ID_TIPO_ENFERMEDAD) {
    this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
    return this;
  }

  public Enfermedad ENFERMEDAD(String ENFERMEDAD) {
    this.ENFERMEDAD = ENFERMEDAD;
    return this;
  }

  public Enfermedad DESCRIPCION(String DESCRIPCION) {
    this.DESCRIPCION = DESCRIPCION;
    return this;
  }

  public Enfermedad SOLUCION(String SOLUCION) {
    this.SOLUCION = SOLUCION;
    return this;
  }

  public Enfermedad FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_ENFERMEDAD='" + getID_ENFERMEDAD() + "'" +
      ", ID_TIPO_ENFERMEDAD='" + getID_TIPO_ENFERMEDAD() + "'" +
      ", ENFERMEDAD='" + getENFERMEDAD() + "'" +
      ", DESCRIPCION='" + getDESCRIPCION() + "'" +
      ", SOLUCION='" + getSOLUCION() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      "}";
  }

}