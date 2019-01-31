package com.dbsm.models.catalogo;

/**
 *
 * @author Grupo 5
 * --TABLE COLONIA
 */
public class Colonia {
 
    public Integer ID_COLONIA;
    public Municipios MUNICIPIO;
    public String COLONIA;

    public Colonia() {
    }

    public Colonia(Integer ID_COLONIA, Municipios MUNICIPIO, String COLONIA) {
        this.ID_COLONIA = ID_COLONIA;
        this.MUNICIPIO = MUNICIPIO;
        this.COLONIA = COLONIA;
    }

    public Integer getID_COLONIA() {
        return ID_COLONIA;
    }

    public void setID_COLONIA(Integer ID_COLONIA) {
        this.ID_COLONIA = ID_COLONIA;
    }

    public Municipios getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(Municipios MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public String getCOLONIA() {
        return COLONIA;
    }

    public void setCOLONIA(String COLONIA) {
        this.COLONIA = COLONIA;
    }
     

}
