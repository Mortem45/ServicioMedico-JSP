package com.dbsm.models.catalogo;

public class Especialidad {

  private Integer ID_ESPECIALIDAD;
  private String ESPECIALIDAD;

  public Especialidad() {
  }

  public Especialidad(Integer ID_ESPECIALIDAD, String ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    this.ESPECIALIDAD = ESPECIALIDAD;
  }

  public Integer getID_ESPECIALIDAD() {
    return this.ID_ESPECIALIDAD;
  }

  public void setID_ESPECIALIDAD(Integer ID_ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
  }

  public String getESPECIALIDAD() {
    return this.ESPECIALIDAD;
  }

  public void setESPECIALIDAD(String ESPECIALIDAD) {
    this.ESPECIALIDAD = ESPECIALIDAD;
  }

  public Especialidad ID_ESPECIALIDAD(Integer ID_ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    return this;
  }

  public Especialidad ESPECIALIDAD(String ESPECIALIDAD) {
    this.ESPECIALIDAD = ESPECIALIDAD;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_ESPECIALIDAD='" + getID_ESPECIALIDAD() + "'" +
      ", ESPECIALIDAD='" + getESPECIALIDAD() + "'" +
      "}";
  }

}