package com.dbsm.models;

import java.util.Date;

/**
 * Historial_Clinico
 */
public class Historial_Clinico {

  private Integer ID_HISTORIAL_CLINICO;
  private Integer ID_PERSONA;
  private Integer ID_SIGNOS_VITALES;
  private String VIA_INGRESO;
  private String USUARIO_REGISTRO;
  private String CLINICA;
  private String OBSERVACIONES;
  private Date FECHA_INGRESO;
  private Integer ALTURA;
  private Integer PESO_ACTUAL;
  private Integer PESO_ANTERIOR;
  private Integer MEDIDA_CINTURA;
  private Integer MASA_MUSCULAR;
  private Date FECHA_REGISTRO;
  private String PRESION_ARTERIAL;


  public Historial_Clinico() {
  }

  public Historial_Clinico(Integer ID_HISTORIAL_CLINICO, Integer ID_PERSONA, Integer ID_SIGNOS_VITALES, String VIA_INGRESO, String USUARIO_REGISTRO, String CLINICA, String OBSERVACIONES, Date FECHA_INGRESO, Integer ALTURA, Integer PESO_ACTUAL, Integer PESO_ANTERIOR, Integer MEDIDA_CINTURA, Integer MASA_MUSCULAR, Date FECHA_REGISTRO, String PRESION_ARTERIAL) {
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
    this.ID_PERSONA = ID_PERSONA;
    this.ID_SIGNOS_VITALES = ID_SIGNOS_VITALES;
    this.VIA_INGRESO = VIA_INGRESO;
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    this.CLINICA = CLINICA;
    this.OBSERVACIONES = OBSERVACIONES;
    this.FECHA_INGRESO = FECHA_INGRESO;
    this.ALTURA = ALTURA;
    this.PESO_ACTUAL = PESO_ACTUAL;
    this.PESO_ANTERIOR = PESO_ANTERIOR;
    this.MEDIDA_CINTURA = MEDIDA_CINTURA;
    this.MASA_MUSCULAR = MASA_MUSCULAR;
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    this.PRESION_ARTERIAL = PRESION_ARTERIAL;
  }

  public Integer getID_HISTORIAL_CLINICO() {
    return this.ID_HISTORIAL_CLINICO;
  }

  public void setID_HISTORIAL_CLINICO(Integer ID_HISTORIAL_CLINICO) {
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
  }

  public Integer getID_PERSONA() {
    return this.ID_PERSONA;
  }

  public void setID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
  }

  public Integer getID_SIGNOS_VITALES() {
    return this.ID_SIGNOS_VITALES;
  }

  public void setID_SIGNOS_VITALES(Integer ID_SIGNOS_VITALES) {
    this.ID_SIGNOS_VITALES = ID_SIGNOS_VITALES;
  }

  public String getVIA_INGRESO() {
    return this.VIA_INGRESO;
  }

  public void setVIA_INGRESO(String VIA_INGRESO) {
    this.VIA_INGRESO = VIA_INGRESO;
  }

  public String getUSUARIO_REGISTRO() {
    return this.USUARIO_REGISTRO;
  }

  public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
  }

  public String getCLINICA() {
    return this.CLINICA;
  }

  public void setCLINICA(String CLINICA) {
    this.CLINICA = CLINICA;
  }

  public String getOBSERVACIONES() {
    return this.OBSERVACIONES;
  }

  public void setOBSERVACIONES(String OBSERVACIONES) {
    this.OBSERVACIONES = OBSERVACIONES;
  }

  public Date getFECHA_INGRESO() {
    return this.FECHA_INGRESO;
  }

  public void setFECHA_INGRESO(Date FECHA_INGRESO) {
    this.FECHA_INGRESO = FECHA_INGRESO;
  }

  public Integer getALTURA() {
    return this.ALTURA;
  }

  public void setALTURA(Integer ALTURA) {
    this.ALTURA = ALTURA;
  }

  public Integer getPESO_ACTUAL() {
    return this.PESO_ACTUAL;
  }

  public void setPESO_ACTUAL(Integer PESO_ACTUAL) {
    this.PESO_ACTUAL = PESO_ACTUAL;
  }

  public Integer getPESO_ANTERIOR() {
    return this.PESO_ANTERIOR;
  }

  public void setPESO_ANTERIOR(Integer PESO_ANTERIOR) {
    this.PESO_ANTERIOR = PESO_ANTERIOR;
  }

  public Integer getMEDIDA_CINTURA() {
    return this.MEDIDA_CINTURA;
  }

  public void setMEDIDA_CINTURA(Integer MEDIDA_CINTURA) {
    this.MEDIDA_CINTURA = MEDIDA_CINTURA;
  }

  public Integer getMASA_MUSCULAR() {
    return this.MASA_MUSCULAR;
  }

  public void setMASA_MUSCULAR(Integer MASA_MUSCULAR) {
    this.MASA_MUSCULAR = MASA_MUSCULAR;
  }

  public Date getFECHA_REGISTRO() {
    return this.FECHA_REGISTRO;
  }

  public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
  }

  public String getPRESION_ARTERIAL() {
    return this.PRESION_ARTERIAL;
  }

  public void setPRESION_ARTERIAL(String PRESION_ARTERIAL) {
    this.PRESION_ARTERIAL = PRESION_ARTERIAL;
  }

  public Historial_Clinico ID_HISTORIAL_CLINICO(Integer ID_HISTORIAL_CLINICO) {
    this.ID_HISTORIAL_CLINICO = ID_HISTORIAL_CLINICO;
    return this;
  }

  public Historial_Clinico ID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
    return this;
  }

  public Historial_Clinico ID_SIGNOS_VITALES(Integer ID_SIGNOS_VITALES) {
    this.ID_SIGNOS_VITALES = ID_SIGNOS_VITALES;
    return this;
  }

  public Historial_Clinico VIA_INGRESO(String VIA_INGRESO) {
    this.VIA_INGRESO = VIA_INGRESO;
    return this;
  }

  public Historial_Clinico USUARIO_REGISTRO(String USUARIO_REGISTRO) {
    this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    return this;
  }

  public Historial_Clinico CLINICA(String CLINICA) {
    this.CLINICA = CLINICA;
    return this;
  }

  public Historial_Clinico OBSERVACIONES(String OBSERVACIONES) {
    this.OBSERVACIONES = OBSERVACIONES;
    return this;
  }

  public Historial_Clinico FECHA_INGRESO(Date FECHA_INGRESO) {
    this.FECHA_INGRESO = FECHA_INGRESO;
    return this;
  }

  public Historial_Clinico ALTURA(Integer ALTURA) {
    this.ALTURA = ALTURA;
    return this;
  }

  public Historial_Clinico PESO_ACTUAL(Integer PESO_ACTUAL) {
    this.PESO_ACTUAL = PESO_ACTUAL;
    return this;
  }

  public Historial_Clinico PESO_ANTERIOR(Integer PESO_ANTERIOR) {
    this.PESO_ANTERIOR = PESO_ANTERIOR;
    return this;
  }

  public Historial_Clinico MEDIDA_CINTURA(Integer MEDIDA_CINTURA) {
    this.MEDIDA_CINTURA = MEDIDA_CINTURA;
    return this;
  }

  public Historial_Clinico MASA_MUSCULAR(Integer MASA_MUSCULAR) {
    this.MASA_MUSCULAR = MASA_MUSCULAR;
    return this;
  }

  public Historial_Clinico FECHA_REGISTRO(Date FECHA_REGISTRO) {
    this.FECHA_REGISTRO = FECHA_REGISTRO;
    return this;
  }

  public Historial_Clinico PRESION_ARTERIAL(String PRESION_ARTERIAL) {
    this.PRESION_ARTERIAL = PRESION_ARTERIAL;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_HISTORIAL_CLINICO='" + getID_HISTORIAL_CLINICO() + "'" +
      ", ID_PERSONA='" + getID_PERSONA() + "'" +
      ", ID_SIGNOS_VITALES='" + getID_SIGNOS_VITALES() + "'" +
      ", VIA_INGRESO='" + getVIA_INGRESO() + "'" +
      ", USUARIO_REGISTRO='" + getUSUARIO_REGISTRO() + "'" +
      ", CLINICA='" + getCLINICA() + "'" +
      ", OBSERVACIONES='" + getOBSERVACIONES() + "'" +
      ", FECHA_INGRESO='" + getFECHA_INGRESO() + "'" +
      ", ALTURA='" + getALTURA() + "'" +
      ", PESO_ACTUAL='" + getPESO_ACTUAL() + "'" +
      ", PESO_ANTERIOR='" + getPESO_ANTERIOR() + "'" +
      ", MEDIDA_CINTURA='" + getMEDIDA_CINTURA() + "'" +
      ", MASA_MUSCULAR='" + getMASA_MUSCULAR() + "'" +
      ", FECHA_REGISTRO='" + getFECHA_REGISTRO() + "'" +
      ", PRESION_ARTERIAL='" + getPRESION_ARTERIAL() + "'" +
      "}";
  }

}