package com.dbsm.models;

/**
 *
 * @author Grupo 5
 * --TABLE DIRECCION_PERSONA
 */
public class Direccion_persona {
 
    public Integer ID_DIRECCION;
    public Integer ID_ZONA;

    public Direccion_persona() {
    }

    public Direccion_persona(Integer ID_DIRECCION, Integer ID_ZONA) {
        this.ID_DIRECCION = ID_DIRECCION;
        this.ID_ZONA = ID_ZONA;
    }

    public Integer getID_DIRECCION() {
        return ID_DIRECCION;
    }

    public void setID_DIRECCION(Integer ID_DIRECCION) {
        this.ID_DIRECCION = ID_DIRECCION;
    }

    public Integer getID_ZONA() {
        return ID_ZONA;
    }

    public void setID_ZONA(Integer ID_ZONA) {
        this.ID_ZONA = ID_ZONA;
    }
    
}
