package com.dbsm.models;

import java.util.Date;

/**
 * Cita
 */
public class Cita {
private Integer ID_CITA;
private Integer ID_SEGURO;
private Integer ID_PERSONA_PACIENTE;
private String CITA;
private Date FECHA_REGISTRO;
private String USUARIO_REGISTRO;
private Date FECHA_CITA;
private Date HORA_CITA;


  public Cita() {
  }
  public Cita(Integer ID_CITA, String CITA) {
    this.ID_CITA = ID_CITA;
    this.CITA = CITA;
  }

  public Cita(Integer ID_CITA, Integer ID_SEGURO, Integer ID_PERSONA_PACIENTE, String CITA, Date FECHA_REGISTRO, String USUARIO_REGISTRO, Date FECHA_CITA, Date HORA_CITA) {
    this.ID_CITA = ID_CITA;
    this.ID_SEGURO = ID_SEGURO;
    this.ID_PERSONA_PACIENTE = ID_PERSONA_PACIENTE;
    this.CITA = CITA;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    this.FECHA_CITA = FECHA_CITA;
    this.HORA_CITA = HORA_CITA;
  }

  public Integer getID_CITA() {
    return this.ID_CITA;
  }

  public void setID_CITA(Integer ID_CITA) {
    this.ID_CITA = ID_CITA;
  }

  public Integer getID_SEGURO() {
    return this.ID_SEGURO;
  }

  public void setID_SEGURO(Integer ID_SEGURO) {
    this.ID_SEGURO = ID_SEGURO;
  }

  public Integer getID_PERSONA_PACIENTE() {
    return this.ID_PERSONA_PACIENTE;
  }

  public void setID_PERSONA_PACIENTE(Integer ID_PERSONA_PACIENTE) {
    this.ID_PERSONA_PACIENTE = ID_PERSONA_PACIENTE;
  }

  public String getCITA() {
    return this.CITA;
  }

  public void setCITA(String CITA) {
    this.CITA = CITA;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public String getUSUARIO_REGISTRO() {
    return this.USUARIO_REGISTRO;
  }

  public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
  }

  public Date getFECHA_CITA() {
    return this.FECHA_CITA;
  }

  public void setFECHA_CITA(Date FECHA_CITA) {
    this.FECHA_CITA = FECHA_CITA;
  }

  public Date getHORA_CITA() {
    return this.HORA_CITA;
  }

  public void setHORA_CITA(Date HORA_CITA) {
    this.HORA_CITA = HORA_CITA;
  }

  public Cita ID_CITA(Integer ID_CITA) {
    this.ID_CITA = ID_CITA;
    return this;
  }

  public Cita ID_SEGURO(Integer ID_SEGURO) {
    this.ID_SEGURO = ID_SEGURO;
    return this;
  }

  public Cita ID_PERSONA_PACIENTE(Integer ID_PERSONA_PACIENTE) {
    this.ID_PERSONA_PACIENTE = ID_PERSONA_PACIENTE;
    return this;
  }

  public Cita CITA(String CITA) {
    this.CITA = CITA;
    return this;
  }

  public Cita FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  public Cita USUARIO_REGISTRO(String USUARIO_REGISTRO) {
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    return this;
  }

  public Cita FECHA_CITA(Date FECHA_CITA) {
    this.FECHA_CITA = FECHA_CITA;
    return this;
  }

  public Cita HORA_CITA(Date HORA_CITA) {
    this.HORA_CITA = HORA_CITA;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_CITA='" + getID_CITA() + "'" +
      ", ID_SEGURO='" + getID_SEGURO() + "'" +
      ", ID_PERSONA_PACIENTE='" + getID_PERSONA_PACIENTE() + "'" +
      ", CITA='" + getCITA() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      ", USUARIO_REGISTRO='" + getUSUARIO_REGISTRO() + "'" +
      ", FECHA_CITA='" + getFECHA_CITA() + "'" +
      ", HORA_CITA='" + getHORA_CITA() + "'" +
      "}";
  }

}