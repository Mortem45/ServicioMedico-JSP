package com.dbsm.models;

import java.lang.reflect.Constructor;

public class Cita_persona {

  public Integer ID_CITA;
  public Integer ID_PERSONA;


  public Cita_persona() {
  }

  public Cita_persona(Integer ID_CITA, Integer ID_PERSONA) {
    this.ID_CITA = ID_CITA;
    this.ID_PERSONA = ID_PERSONA;
  }

  public Integer getID_CITA() {
    return this.ID_CITA;
  }

  public void setID_CITA(Integer ID_CITA) {
    this.ID_CITA = ID_CITA;
  }

  public Integer getID_PERSONA() {
    return this.ID_PERSONA;
  }

  public void setID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
  }

  public Cita_persona ID_CITA(Integer ID_CITA) {
    this.ID_CITA = ID_CITA;
    return this;
  }

  public Cita_persona ID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_CITA='" + getID_CITA() + "'" +
      ", ID_PERSONA='" + getID_PERSONA() + "'" +
      "}";
  }

}
