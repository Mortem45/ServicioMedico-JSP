package com.dbsm.models;

/**
 *
 * @author Grupo 5
 * --TABLE DIRECCION
 */
public class Direccion {
 
    public Integer ID_DIRECCION;
    public Integer ID_ZONA;
    public Integer ID_MUNICIPIO;
    public Integer ID_COLONIA;
    public String CALLE_AVENIDA;
    public String NUMERO;
    public String EDIFICIO;

    public Direccion() {
    }

    public Direccion(Integer ID_DIRECCION, Integer ID_ZONA, Integer ID_MUNICIPIO, Integer ID_COLONIA, String CALLE_AVENIDA, String NUMERO, String EDIFICIO) {
        this.ID_DIRECCION = ID_DIRECCION;
        this.ID_ZONA = ID_ZONA;
        this.ID_MUNICIPIO = ID_MUNICIPIO;
        this.ID_COLONIA = ID_COLONIA;
        this.CALLE_AVENIDA = CALLE_AVENIDA;
        this.NUMERO = NUMERO;
        this.EDIFICIO = EDIFICIO;
    }

    public Direccion(Integer ID_ZONA, Integer ID_MUNICIPIO, Integer ID_COLONIA, String CALLE_AVENIDA, String NUMERO, String EDIFICIO) {
        this.ID_ZONA = ID_ZONA;
        this.ID_MUNICIPIO = ID_MUNICIPIO;
        this.ID_COLONIA = ID_COLONIA;
        this.CALLE_AVENIDA = CALLE_AVENIDA;
        this.NUMERO = NUMERO;
        this.EDIFICIO = EDIFICIO;
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

    public Integer getID_MUNICIPIO() {
        return ID_MUNICIPIO;
    }

    public void setID_MUNICIPIO(Integer ID_MUNICIPIO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
    }

    public Integer getID_COLONIA() {
        return ID_COLONIA;
    }

    public void setID_COLONIA(Integer ID_COLONIA) {
        this.ID_COLONIA = ID_COLONIA;
    }

    public String getCALLE_AVENIDA() {
        return CALLE_AVENIDA;
    }

    public void setCALLE_AVENIDA(String CALLE_AVENIDA) {
        this.CALLE_AVENIDA = CALLE_AVENIDA;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getEDIFICIO() {
        return EDIFICIO;
    }

    public void setEDIFICIO(String EDIFICIO) {
        this.EDIFICIO = EDIFICIO;
    }

    
}
