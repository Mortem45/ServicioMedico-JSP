package com.dbsm.models;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE MOVIMIENTOS_HISTORIAL
 */
public class Movimientos_historial {
 
    public Integer ID_MOVIMIENTO_HISTORIAL;
    public Integer ID_ENFERMEDAD;
    public Integer ID_EXAMEN;
    public Integer ID_SUSPENCION;
    public String FALLECIMIENTO;
    public String ALTAS;
    public Integer USUARIO_REGISTRO;
    public Date FECHA_REGISTRO;

    public Movimientos_historial(Integer ID_MOVIMIENTO_HISTORIAL, Integer ID_ENFERMEDAD, Integer ID_EXAMEN, Integer ID_SUSPENCION, String FALLECIMIENTO, String ALTAS, Integer USUARIO_REGISTRO, Date FECHA_REGISTRO) {
        this.ID_MOVIMIENTO_HISTORIAL = ID_MOVIMIENTO_HISTORIAL;
        this.ID_ENFERMEDAD = ID_ENFERMEDAD;
        this.ID_EXAMEN = ID_EXAMEN;
        this.ID_SUSPENCION = ID_SUSPENCION;
        this.FALLECIMIENTO = FALLECIMIENTO;
        this.ALTAS = ALTAS;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Movimientos_historial() {
    }

    public Integer getID_MOVIMIENTO_HISTORIAL() {
        return ID_MOVIMIENTO_HISTORIAL;
    }

    public void setID_MOVIMIENTO_HISTORIAL(Integer ID_MOVIMIENTO_HISTORIAL) {
        this.ID_MOVIMIENTO_HISTORIAL = ID_MOVIMIENTO_HISTORIAL;
    }

    public Integer getID_ENFERMEDAD() {
        return ID_ENFERMEDAD;
    }

    public void setID_ENFERMEDAD(Integer ID_ENFERMEDAD) {
        this.ID_ENFERMEDAD = ID_ENFERMEDAD;
    }

    public Integer getID_EXAMEN() {
        return ID_EXAMEN;
    }

    public void setID_EXAMEN(Integer ID_EXAMEN) {
        this.ID_EXAMEN = ID_EXAMEN;
    }

    public Integer getID_SUSPENCION() {
        return ID_SUSPENCION;
    }

    public void setID_SUSPENCION(Integer ID_SUSPENCION) {
        this.ID_SUSPENCION = ID_SUSPENCION;
    }

    public String getFALLECIMIENTO() {
        return FALLECIMIENTO;
    }

    public void setFALLECIMIENTO(String FALLECIMIENTO) {
        this.FALLECIMIENTO = FALLECIMIENTO;
    }

    public String getALTAS() {
        return ALTAS;
    }

    public void setALTAS(String ALTAS) {
        this.ALTAS = ALTAS;
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