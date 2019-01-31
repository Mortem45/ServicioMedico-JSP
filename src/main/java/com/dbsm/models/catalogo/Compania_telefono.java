package com.dbsm.models.catalogo;

/**
 *
 * @author Grupo 5
 * --TABLE COMPANIA_TELEFONO
 */
public class Compania_telefono {
 
    public Integer ID_COMPANIA;
    public String COMPANIA;

    public Compania_telefono() {
    }

    public Compania_telefono(Integer ID_COMPANIA, String COMPANIA) {
        this.ID_COMPANIA = ID_COMPANIA;
        this.COMPANIA = COMPANIA;
    }

    public Integer getID_COMPANIA() {
        return ID_COMPANIA;
    }

    public void setID_COMPANIA(Integer ID_COMPANIA) {
        this.ID_COMPANIA = ID_COMPANIA;
    }

    public String getCOMPANIA() {
        return COMPANIA;
    }

    public void setCOMPANIA(String COMPANIA) {
        this.COMPANIA = COMPANIA;
    }

}
