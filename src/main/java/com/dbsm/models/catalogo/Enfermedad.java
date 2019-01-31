package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE ENFERMEDAD
 */
public class Enfermedad {
 
    public Integer ID_ENFERMEDAD;
    public Tipo_enfermedad TIPO_ENFERMEDAD;
    public String ENFERMEDAD;
    public Integer USUARIO_REGISTRO;
    public String DESCRIPCION;
    public String SOLUCION;
    public Date FECHA_REGISTRO;

    public Enfermedad() {
    }

    public Enfermedad(Integer ID_ENFERMEDAD, Tipo_enfermedad TIPO_ENFERMEDAD, String ENFERMEDAD, Integer USUARIO_REGISTRO, String DESCRIPCION, String SOLUCION, Date FECHA_REGISTRO) {
        this.ID_ENFERMEDAD = ID_ENFERMEDAD;
        this.TIPO_ENFERMEDAD = TIPO_ENFERMEDAD;
        this.ENFERMEDAD = ENFERMEDAD;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
        this.DESCRIPCION = DESCRIPCION;
        this.SOLUCION = SOLUCION;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Integer getID_ENFERMEDAD() {
        return ID_ENFERMEDAD;
    }

    public void setID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
        this.ID_ENFERMEDAD = ID_ENFERMEDAD;
    }

    public Tipo_enfermedad getTIPO_ENFERMEDAD() {
        return TIPO_ENFERMEDAD;
    }

    public void setTIPO_ENFERMEDAD(Tipo_enfermedad TIPO_ENFERMEDAD) {
        this.TIPO_ENFERMEDAD = TIPO_ENFERMEDAD;
    }

    public String getENFERMEDAD() {
        return ENFERMEDAD;
    }

    public void setENFERMEDAD(String ENFERMEDAD) {
        this.ENFERMEDAD = ENFERMEDAD;
    }

    public Integer getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(Integer USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getSOLUCION() {
        return SOLUCION;
    }

    public void setSOLUCION(String SOLUCION) {
        this.SOLUCION = SOLUCION;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }
}