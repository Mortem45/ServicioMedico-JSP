package com.dbsm.models;

/**
 * Medico
 */
public class Medico {

  private Integer ID_PERSONA;
  private Integer ID_MEDICO;
  private Integer ID_ESPECIALIDAD;
  private String FECHA_INGRESO;

  public Medico() {
  }

  public Medico(Integer ID_PERSONA, Integer ID_MEDICO, Integer ID_ESPECIALIDAD, String FECHA_INGRESO) {
    this.ID_PERSONA = ID_PERSONA;
    this.ID_MEDICO = ID_MEDICO;
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    this.FECHA_INGRESO = FECHA_INGRESO;
  }

  public Integer getID_PERSONA() {
    return this.ID_PERSONA;
  }

  public void setID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
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

  public String getFECHA_INGRESO() {
    return this.FECHA_INGRESO;
  }

  public void setFECHA_INGRESO(String FECHA_INGRESO) {
    this.FECHA_INGRESO = FECHA_INGRESO;
  }

  public Medico ID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
    return this;
  }

  public Medico ID_MEDICO(Integer ID_MEDICO) {
    this.ID_MEDICO = ID_MEDICO;
    return this;
  }

  public Medico ID_ESPECIALIDAD(Integer ID_ESPECIALIDAD) {
    this.ID_ESPECIALIDAD = ID_ESPECIALIDAD;
    return this;
  }

  public Medico FECHA_INGRESO(String FECHA_INGRESO) {
    this.FECHA_INGRESO = FECHA_INGRESO;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_PERSONA='" + getID_PERSONA() + "'" +
      ", ID_MEDICO='" + getID_MEDICO() + "'" +
      ", ID_ESPECIALIDAD='" + getID_ESPECIALIDAD() + "'" +
      ", FECHA_INGRESO='" + getFECHA_INGRESO() + "'" +
      "}";
  }

}