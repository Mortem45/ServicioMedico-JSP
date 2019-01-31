package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE TIPO_ENFERMEDAD
 */
public class Tipo_enfermedad {
 
    public Integer ID_TIPO_ENFERMEDAD;
    public String TIPO_ENFERMEDAD;
    public Integer USUARIO_REGISTRO;
    public Date FECHA_REGISTRO;

    public Tipo_enfermedad() {
    }

    public Tipo_enfermedad(Integer ID_TIPO_ENFERMEDAD, String TIPO_ENFERMEDAD, Integer USUARIO_REGISTRO, Date FECHA_REGISTRO) {
        this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
        this.TIPO_ENFERMEDAD = TIPO_ENFERMEDAD;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Tipo_enfermedad(Integer ID_TIPO_ENFERMEDAD) {
        this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
    }
    
    public Tipo_enfermedad(Integer ID_TIPO_ENFERMEDAD, String TIPO_ENFERMEDAD) {
        this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
        this.TIPO_ENFERMEDAD = TIPO_ENFERMEDAD;
    }

    public Integer getID_TIPO_ENFERMEDAD() {
        return ID_TIPO_ENFERMEDAD;
    }

    public void setID_TIPO_ENFERMEDAD(Integer ID_TIPO_ENFERMEDAD) {
        this.ID_TIPO_ENFERMEDAD = ID_TIPO_ENFERMEDAD;
    }

    public String getTIPO_ENFERMEDAD() {
        return TIPO_ENFERMEDAD;
    }

    public void setTIPO_ENFERMEDAD(String TIPO_ENFERMEDAD) {
        this.TIPO_ENFERMEDAD = TIPO_ENFERMEDAD;
    }

    public Integer getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(Integer USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

}