package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE MUNICIPIOS
 */
public class Municipios {
 
    public Integer ID_MUNICIPIO;
    public Departamento DEPARTAMENTO;
    public Pais PAIS;
    public String MUNICIPIO;
    public Date FECHA_REGISTRO;

    public Municipios() {
    }
    
    public Municipios(Integer ID_MUNICIPIO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
    }
    
    public Municipios(Integer ID_MUNICIPIO, Departamento DEPARTAMENTO, Pais PAIS, String MUNICIPIO, Date FECHA_REGISTRO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.PAIS = PAIS;
        this.MUNICIPIO = MUNICIPIO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Municipios(Integer ID_MUNICIPIO, String MUNICIPIO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
        this.MUNICIPIO = MUNICIPIO;
    }

    public Integer getID_MUNICIPIO() {
        return ID_MUNICIPIO;
    }

    public void setID_MUNICIPIO(Integer ID_MUNICIPIO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
    }

    public Departamento getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(Departamento ID_DEPARTAMENTO) {
        this.DEPARTAMENTO = ID_DEPARTAMENTO;
    }

    public Pais getPAIS() {
        return PAIS;
    }

    public void setPAIS(Pais ID_PAIS) {
        this.PAIS = ID_PAIS;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

}
