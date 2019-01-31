package com.dbsm.models;

import java.util.Date;

/**
 * Diagnostico
 */
public class Diagnostico {
  private Integer ID_DIAGNOSTICO;
  private Integer ID_PERSONA;
  private Integer ID_HISTORIAL_CLINICO;
  private String DIAGNOSTICO;
  private Date FECHA_REGISTRO;
  private Integer ID_ENFERMEDAD;


  public Diagnostico() {
  }

  public Diagnostico(Integer ID_DIAGNOSTICO, Integer ID_PERSONA, Integer ID_HISTORIAL_CLINICO, String DIAGNOSTICO, Date FECHA_REGISTRO, Integer ID_ENFERMEDAD) {
    this.ID_DIAGNOSTICO = ID_DIAGNOSTICO;
    this.ID_PERSONA = ID_PERSONA;
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
    this.DIAGNOSTICO = DIAGNOSTICO;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
  }

  public Integer getID_DIAGNOSTICO() {
    return this.ID_DIAGNOSTICO;
  }

  public void setID_DIAGNOSTICO(Integer ID_DIAGNOSTICO) {
    this.ID_DIAGNOSTICO = ID_DIAGNOSTICO;
  }

  public Integer getID_PERSONA() {
    return this.ID_PERSONA;
  }

  public void setID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
  }

  public Integer getID_HISTORIAL_CLINICO() {
    return this.ID_HISTORIAL_CLINICO;
  }

  public void setID_HISTORIAL_CLINICO(Integer ID_HISTORIAL_CLINICO) {
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
  }

  public String getDIAGNOSTICO() {
    return this.DIAGNOSTICO;
  }

  public void setDIAGNOSTICO(String DIAGNOSTICO) {
    this.DIAGNOSTICO = DIAGNOSTICO;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public Integer getID_ENFERMEDAD() {
    return this.ID_ENFERMEDAD;
  }

  public void setID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
  }

  public Diagnostico ID_DIAGNOSTICO(Integer ID_DIAGNOSTICO) {
    this.ID_DIAGNOSTICO = ID_DIAGNOSTICO;
    return this;
  }

  public Diagnostico ID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
    return this;
  }

  public Diagnostico ID_HISTORIAL_CLINICO(Integer ID_HISTORIAL_CLINICO) {
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
    return this;
  }

  public Diagnostico DIAGNOSTICO(String DIAGNOSTICO) {
    this.DIAGNOSTICO = DIAGNOSTICO;
    return this;
  }

  public Diagnostico FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  public Diagnostico ID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
    this.ID_ENFERMEDAD = ID_ENFERMEDAD;
    return this;
  }
  
  @Override
  public String toString() {
    return "{" +
      " ID_DIAGNOSTICO='" + getID_DIAGNOSTICO() + "'" +
      ", ID_PERSONA='" + getID_PERSONA() + "'" +
      ", ID_HISTORIAL_CLINICO='" + getID_HISTORIAL_CLINICO() + "'" +
      ", DIAGNOSTICO='" + getDIAGNOSTICO() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      ", ID_ENFERMEDAD='" + getID_ENFERMEDAD() + "'" +
      "}";
  }

}