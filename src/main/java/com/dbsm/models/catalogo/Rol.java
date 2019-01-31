package com.dbsm.models.catalogo;

import java.util.Date;

public class Rol {

  private Integer ID_ROL_USUARIO;
  private String NOMBRE;
  private String DESCRIPCION_ROL;
  private Date FECHA_CREACION;
  private String USUARIO_CREACION;
  private Integer STATUS;

  public Rol() {
  }

  public Rol(Integer ID_ROL_USUARIO, String NOMBRE, String DESCRIPCION_ROL, Date FECHA_CREACION, String USUARIO_CREACION, Integer STATUS) {
    this.ID_ROL_USUARIO = ID_ROL_USUARIO;
    this.NOMBRE = NOMBRE;
    this.DESCRIPCION_ROL = DESCRIPCION_ROL;
    this.FECHA_CREACION = FECHA_CREACION;
    this.USUARIO_CREACION = USUARIO_CREACION;
    this.STATUS = STATUS;
  }

  public Integer getID_ROL_USUARIO() {
    return this.ID_ROL_USUARIO;
  }

  public void setID_ROL_USUARIO(Integer ID_ROL_USUARIO) {
    this.ID_ROL_USUARIO = ID_ROL_USUARIO;
  }

  public String getNOMBRE() {
    return this.NOMBRE;
  }

  public void setNOMBRE(String NOMBRE) {
    this.NOMBRE = NOMBRE;
  }

  public String getDESCRIPCION_ROL() {
    return this.DESCRIPCION_ROL;
  }

  public void setDESCRIPCION_ROL(String DESCRIPCION_ROL) {
    this.DESCRIPCION_ROL = DESCRIPCION_ROL;
  }

  public Date getFECHA_CREACION() {
    return this.FECHA_CREACION;
  }

  public void setFECHA_CREACION(Date FECHA_CREACION) {
    this.FECHA_CREACION = FECHA_CREACION;
  }

  public String getUSUARIO_CREACION() {
    return this.USUARIO_CREACION;
  }

  public void setUSUARIO_CREACION(String USUARIO_CREACION) {
    this.USUARIO_CREACION = USUARIO_CREACION;
  }

  public Integer getSTATUS() {
    return this.STATUS;
  }

  public void setSTATUS(Integer STATUS) {
    this.STATUS = STATUS;
  }

  public Rol ID_ROL_USUARIO(Integer ID_ROL_USUARIO) {
    this.ID_ROL_USUARIO = ID_ROL_USUARIO;
    return this;
  }

  public Rol NOMBRE(String NOMBRE) {
    this.NOMBRE = NOMBRE;
    return this;
  }

  public Rol DESCRIPCION_ROL(String DESCRIPCION_ROL) {
    this.DESCRIPCION_ROL = DESCRIPCION_ROL;
    return this;
  }

  public Rol FECHA_CREACION(Date FECHA_CREACION) {
    this.FECHA_CREACION = FECHA_CREACION;
    return this;
  }

  public Rol USUARIO_CREACION(String USUARIO_CREACION) {
    this.USUARIO_CREACION = USUARIO_CREACION;
    return this;
  }

  public Rol STATUS(Integer STATUS) {
    this.STATUS = STATUS;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_ROL_USUARIO='" + getID_ROL_USUARIO() + "'" +
      ", NOMBRE='" + getNOMBRE() + "'" +
      ", DESCRIPCION_ROL='" + getDESCRIPCION_ROL() + "'" +
      ", FECHA_CREACION='" + getFECHA_CREACION() + "'" +
      ", USUARIO_CREACION='" + getUSUARIO_CREACION() + "'" +
      ", STATUS='" + getSTATUS() + "'" +
      "}";
  }

}