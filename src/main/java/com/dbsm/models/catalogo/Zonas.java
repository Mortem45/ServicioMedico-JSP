package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * --TABLE ZONAS
 */
public class Zonas {
 
    public Integer ID_ZONA;
    public Municipios MUNICIPIO;
    public Integer ZONA;
    public Date FECHA_REGISTRO;
    public String USUARIO_REGISTRO;

    public Zonas() {
    }

    public Zonas(Integer ID_ZONA, Municipios MUNICIPIO, Integer ZONA, Date FECHA_REGISTRO, String USUARIO_REGISTRO) {
        this.ID_ZONA = ID_ZONA;
        this.MUNICIPIO = MUNICIPIO;
        this.ZONA = ZONA;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }
    
    public Integer getID_ZONA() {
        return ID_ZONA;
    }

    public void setID_ZONA(Integer ID_ZONA) {
        this.ID_ZONA = ID_ZONA;
    }

    public Municipios getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(Municipios MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public Integer getZONA() {
        return ZONA;
    }

    public void setZONA(Integer ZONA) {
        this.ZONA = ZONA;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public String getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }
    
    
}
