package com.dbsm.models.catalogo;

/**
 *
 * @author Grupo 5
 * --TABLE TIPO_TELEFONO
 */
public class Tipo_telefono {
 
    public Integer ID_TIPO_TELEFONO;
    public String TIPO_TELEFONO;

    public Tipo_telefono() {
    }

    public Tipo_telefono(Integer ID_TIPO_TELEFONO, String TIPO_TELEFONO) {
        this.ID_TIPO_TELEFONO = ID_TIPO_TELEFONO;
        this.TIPO_TELEFONO = TIPO_TELEFONO;
    }

    public Integer getID_TIPO_TELEFONO() {
        return ID_TIPO_TELEFONO;
    }

    public void setID_TIPO_TELEFONO(Integer ID_TIPO_TELEFONO) {
        this.ID_TIPO_TELEFONO = ID_TIPO_TELEFONO;
    }

    public String getTIPO_TELEFONO() {
        return TIPO_TELEFONO;
    }

    public void setTIPO_TELEFONO(String TIPO_TELEFONO) {
        this.TIPO_TELEFONO = TIPO_TELEFONO;
    }

}
