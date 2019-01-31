package com.dbsm.models;

/**
 *
 * @author Grupo 5
 * --TABLE SEDE
 */
public class Sede {
 
    public Integer ID_SEDE;
    public Integer ID_DIRECCION;
    public String NOMBRE;

    public Sede(Integer ID_SEDE, Integer ID_DIRECCION, String NOMBRE) {
        this.ID_SEDE = ID_SEDE;
        this.ID_DIRECCION = ID_DIRECCION;
        this.NOMBRE = NOMBRE;
    }

    public Sede() {
    }

    public Integer getID_SEDE() {
        return ID_SEDE;
    }

    public void setID_SEDE(Integer ID_SEDE) {
        this.ID_SEDE = ID_SEDE;
    }

    public Integer getID_DIRECCION() {
        return ID_DIRECCION;
    }

    public void setID_DIRECCION(Integer ID_DIRECCION) {
        this.ID_DIRECCION = ID_DIRECCION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

}
