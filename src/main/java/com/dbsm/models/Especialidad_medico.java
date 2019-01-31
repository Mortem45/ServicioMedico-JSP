package com.dbsm.models;

import java.util.Date;

/**
 * Especialidad_medico
 */
public class Especialidad_medico {

  private Integer ID_MEDICO;
  private Integer ID_ESPECIALIDAD;
  private Date FECHA_REGISTRO;

  public Especialidad_medico() {
  }

  public Especialidad_medico(Integer ID_MEDICO, Integer ID_ESPECIALIDAD, Date FECHA_REGISTRO) {
    this.ID_MEDICO = ID_MEDICO;
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Integer getID_MEDICO() {
    return this.ID_MEDICO;
  }

  public void setID_MEDICO(Integer ID_MEDICO) {
    this.ID_MEDICO = ID_MEDICO;
  }

  public Integer getID_ESPECIALIDAD() {
    return this.ID_ESPECIALIDAD;
  }

  public void setID_ESPECIALIDAD(Integer ID_ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Especialidad_medico ID_MEDICO(Integer ID_MEDICO) {
    this.ID_MEDICO = ID_MEDICO;
    return this;
  }

  public Especialidad_medico ID_ESPECIALIDAD(Integer ID_ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    return this;
  }

  public Especialidad_medico FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_MEDICO='" + getID_MEDICO() + "'" +
      ", ID_ESPECIALIDAD='" + getID_ESPECIALIDAD() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      "}";
  }

}