package com.dbsm.models;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE PERSONA
 */
public class Persona {
 
    public Integer ID_PERSONA;
    public Integer ID_TELEFONO;
    public Integer ID_SEGURO;
    public Integer ID_TIPO_SANGRE;
    public Integer ID_ROL;
    public String PRIMER_NOMBRE;
    public String SEGUNDO_NOMBRE;
    public String PRIMER_APELLIDO;
    public String SEGUNDO_APELLIDO;
    public String APELLIDO_CASADA;
    public Date FECHA_NACIMIENTO;
    public Character GENERO;

    public Persona() {
    }

    public Persona(Integer ID_PERSONA, Integer ID_TELEFONO, Integer ID_SEGURO, Integer ID_TIPO_SANGRE, Integer ID_ROL, String PRIMER_NOMBRE, String SEGUNDO_NOMBRE, String PRIMER_APELLIDO, String SEGUNDO_APELLIDO, String APELLIDO_CASADA, Date FECHA_NACIMIENTO, Character GENERO) {
        this.ID_PERSONA = ID_PERSONA;
        this.ID_TELEFONO = ID_TELEFONO;
        this.ID_SEGURO = ID_SEGURO;
        this.ID_TIPO_SANGRE = ID_TIPO_SANGRE;
        this.ID_ROL = ID_ROL;
        this.PRIMER_NOMBRE = PRIMER_NOMBRE;
        this.SEGUNDO_NOMBRE = SEGUNDO_NOMBRE;
        this.PRIMER_APELLIDO = PRIMER_APELLIDO;
        this.SEGUNDO_APELLIDO = SEGUNDO_APELLIDO;
        this.APELLIDO_CASADA = APELLIDO_CASADA;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
        this.GENERO = GENERO;
    }

    public Integer getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(Integer ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public Integer getID_TELEFONO() {
        return ID_TELEFONO;
    }

    public void setID_TELEFONO(Integer ID_TELEFONO) {
        this.ID_TELEFONO = ID_TELEFONO;
    }

    public Integer getID_SEGURO() {
        return ID_SEGURO;
    }

    public void setID_SEGURO(Integer ID_SEGURO) {
        this.ID_SEGURO = ID_SEGURO;
    }

    public Integer getID_TIPO_SANGRE() {
        return ID_TIPO_SANGRE;
    }

    public void setID_TIPO_SANGRE(Integer ID_TIPO_SANGRE) {
        this.ID_TIPO_SANGRE = ID_TIPO_SANGRE;
    }

    public Integer getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(Integer ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    public String getPRIMER_NOMBRE() {
        return PRIMER_NOMBRE;
    }

    public void setPRIMER_NOMBRE(String PRIMER_NOMBRE) {
        this.PRIMER_NOMBRE = PRIMER_NOMBRE;
    }

    public String getSEGUNDO_NOMBRE() {
        return SEGUNDO_NOMBRE;
    }

    public void setSEGUNDO_NOMBRE(String SEGUNDO_NOMBRE) {
        this.SEGUNDO_NOMBRE = SEGUNDO_NOMBRE;
    }

    public String getPRIMER_APELLIDO() {
        return PRIMER_APELLIDO;
    }

    public void setPRIMER_APELLIDO(String PRIMER_APELLIDO) {
        this.PRIMER_APELLIDO = PRIMER_APELLIDO;
    }

    public String getSEGUNDO_APELLIDO() {
        return SEGUNDO_APELLIDO;
    }

    public void setSEGUNDO_APELLIDO(String SEGUNDO_APELLIDO) {
        this.SEGUNDO_APELLIDO = SEGUNDO_APELLIDO;
    }

    public String getAPELLIDO_CASADA() {
        return APELLIDO_CASADA;
    }

    public void setAPELLIDO_CASADA(String APELLIDO_CASADA) {
        this.APELLIDO_CASADA = APELLIDO_CASADA;
    }

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    public Character getGENERO() {
        return GENERO;
    }

    public void setGENERO(Character GENERO) {
        this.GENERO = GENERO;
    }

    

}
