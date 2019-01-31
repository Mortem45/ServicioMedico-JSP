package com.dbsm.models;

/**
 *
 * @author Grupo 5
 * --TABLE ENCARGADO_SEDE
 */
public class Encargado_sede {
 
    public Integer ID_ENCARGADO_SEDE;
    public Integer ID_SEDE;
    public Integer ID_PERSONA;

    public Encargado_sede() {
    }

    public Encargado_sede(Integer ID_ENCARGADO_SEDE, Integer ID_SEDE, Integer ID_PERSONA) {
        this.ID_ENCARGADO_SEDE = ID_ENCARGADO_SEDE;
        this.ID_SEDE = ID_SEDE;
        this.ID_PERSONA = ID_PERSONA;
    }

    public Integer getID_ENCARGADO_SEDE() {
        return ID_ENCARGADO_SEDE;
    }

    public void setID_ENCARGADO_SEDE(Integer ID_ENCARGADO_SEDE) {
        this.ID_ENCARGADO_SEDE = ID_ENCARGADO_SEDE;
    }

    public Integer getID_SEDE() {
        return ID_SEDE;
    }

    public void setID_SEDE(Integer ID_SEDE) {
        this.ID_SEDE = ID_SEDE;
    }

    public Integer getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(Integer ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }
    
}
