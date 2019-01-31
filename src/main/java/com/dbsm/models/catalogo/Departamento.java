package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE DEPARTAMENTO
 */
public class Departamento {
 
    public Integer ID_DEPARTAMENTO = 0;
    public Pais PAIS;
    public String DEPARTAMENTO;
    public Date FECHA_REGISTRO;

    public Departamento(Integer ID_DEPARTAMENTO, Pais PAIS, String DEPARTAMENTO, Date FECHA_REGISTRO) {
        this.ID_DEPARTAMENTO = ID_DEPARTAMENTO;
        this.PAIS = PAIS;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Departamento() {
    }
    
    public Departamento(Integer ID_DEPARTAMENTO, String DEPARTAMENTO) {
        this.ID_DEPARTAMENTO = ID_DEPARTAMENTO;
        this.DEPARTAMENTO = DEPARTAMENTO;
    }
    
    public Departamento(Integer ID_DEPARTAMENTO) {
        this.ID_DEPARTAMENTO = ID_DEPARTAMENTO;
    }
    
    public Integer getID_DEPARTAMENTO() {
        return ID_DEPARTAMENTO;
    }

    public void setID_DEPARTAMENTO(Integer ID_DEPARTAMENTO) {
        this.ID_DEPARTAMENTO = ID_DEPARTAMENTO;
    }

    public Pais getPAIS() {
        return PAIS;
    }

    public void setPAIS(Pais PAIS) {
        this.PAIS = PAIS;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

}
