package com.dbsm.models;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE EXAMENES
 */
public class Examenes {
 
    public Integer ID_EXAMEN;
    public String EXAMEN;
    public String OBSERVACIONES;
    public Integer USUARIO_REGISTRO;
    public Date FECHA_REGISTRO;

    public Examenes() {
    }

    public Examenes(Integer ID_EXAMEN, String EXAMEN, String OBSERVACIONES, Integer USUARIO_REGISTRO, Date FECHA_REGISTRO) {
        this.ID_EXAMEN = ID_EXAMEN;
        this.EXAMEN = EXAMEN;
        this.OBSERVACIONES = OBSERVACIONES;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Integer getID_EXAMEN() {
        return ID_EXAMEN;
    }

    public void setID_EXAMEN(Integer ID_EXAMEN) {
        this.ID_EXAMEN = ID_EXAMEN;
    }

    public String getEXAMEN() {
        return EXAMEN;
    }

    public void setEXAMEN(String EXAMEN) {
        this.EXAMEN = EXAMEN;
    }

    public String getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void setOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
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