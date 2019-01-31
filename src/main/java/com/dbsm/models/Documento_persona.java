package com.dbsm.models;

/**
 * Documento_persona
 */
public class Documento_persona {
  private Integer ID_TIPO_DOCUMENTO;
  private Integer ID_PERSONA;

  public Documento_persona() {
  }

  public Documento_persona(Integer ID_TIPO_DOCUMENTO, Integer ID_PERSONA) {
    this.ID_TIPO_DOCUMENTO = ID_TIPO_DOCUMENTO;
    this.ID_PERSONA = ID_PERSONA;
  }

  public Integer getID_TIPO_DOCUMENTO() {
    return this.ID_TIPO_DOCUMENTO;
  }

  public void setID_TIPO_DOCUMENTO(Integer ID_TIPO_DOCUMENTO) {
    this.ID_TIPO_DOCUMENTO = ID_TIPO_DOCUMENTO;
  }

  public Integer getID_PERSONA() {
    return this.ID_PERSONA;
  }

  public void setID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
  }

  public Documento_persona ID_TIPO_DOCUMENTO(Integer ID_TIPO_DOCUMENTO) {
    this.ID_TIPO_DOCUMENTO = ID_TIPO_DOCUMENTO;
    return this;
  }

  public Documento_persona ID_PERSONA(Integer ID_PERSONA) {
    this.ID_PERSONA = ID_PERSONA;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ID_TIPO_DOCUMENTO='" + getID_TIPO_DOCUMENTO() + "'" +
      ", ID_PERSONA='" + getID_PERSONA() + "'" +
      "}";
  }


}