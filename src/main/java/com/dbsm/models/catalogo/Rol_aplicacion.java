package com.dbsm.models.catalogo;

public class Rol_aplicacion {
  private Integer ID_ROL_APLICACION;
  private Integer ID_MENU;


  public Rol_aplicacion() {
  }

  public Rol_aplicacion(Integer ID_ROL_APLICACION, Integer ID_MENU) {
    this.ID_ROL_APLICACION = ID_ROL_APLICACION;
    this.ID_MENU = ID_MENU;
  }

  public Integer getID_ROL_APLICACION() {
    return this.ID_ROL_APLICACION;
  }

  public void setID_ROL_APLICACION(Integer ID_ROL_APLICACION) {
    this.ID_ROL_APLICACION = ID_ROL_APLICACION;
  }

  public Integer getID_MENU() {
    return this.ID_MENU;
  }

  public void setID_MENU(Integer ID_MENU) {
    this.ID_MENU = ID_MENU;
  }

  public Rol_aplicacion ID_ROL_APLICACION(Integer ID_ROL_APLICACION) {
    this.ID_ROL_APLICACION = ID_ROL_APLICACION;
    return this;
  }

  public Rol_aplicacion ID_MENU(Integer ID_MENU) {
    this.ID_MENU = ID_MENU;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_ROL_APLICACION='" + getID_ROL_APLICACION() + "'" +
      ", ID_MENU='" + getID_MENU() + "'" +
      "}";
  }

}


