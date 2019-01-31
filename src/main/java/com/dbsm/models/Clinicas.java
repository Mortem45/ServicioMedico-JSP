package com.dbsm.models;

public class Clinicas {
  private Integer ID_CLINICA;
  private Integer ID_SEDE;
  private String DESCRIPCION;

  public Clinicas() {
  }

  public Clinicas(Integer ID_CLINICA, Integer ID_SEDE, String DESCRIPCION) {
    this.ID_CLINICA = ID_CLINICA;
    this.ID_SEDE = ID_SEDE;
    this.DESCRIPCION = DESCRIPCION;
  }

  public Integer getID_CLINICA() {
    return this.ID_CLINICA;
  }

  public void setID_CLINICA(Integer ID_CLINICA) {
    this.ID_CLINICA = ID_CLINICA;
  }

  public Integer getID_SEDE() {
    return this.ID_SEDE;
  }

  public void setID_SEDE(Integer ID_SEDE) {
    this.ID_SEDE = ID_SEDE;
  }

  public String getDESCRIPCION() {
    return this.DESCRIPCION;
  }

  public void setDESCRIPCION(String DESCRIPCION) {
    this.DESCRIPCION = DESCRIPCION;
  }

  public Clinicas ID_CLINICA(Integer ID_CLINICA) {
    this.ID_CLINICA = ID_CLINICA;
    return this;
  }

  public Clinicas ID_SEDE(Integer ID_SEDE) {
    this.ID_SEDE = ID_SEDE;
    return this;
  }

  public Clinicas DESCRIPCION(String DESCRIPCION) {
    this.DESCRIPCION = DESCRIPCION;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_CLINICA='" + getID_CLINICA() + "'" +
      ", ID_SEDE='" + getID_SEDE() + "'" +
      ", DESCRIPCION='" + getDESCRIPCION() + "'" +
      "}";
  }

}