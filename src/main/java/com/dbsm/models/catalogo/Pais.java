package com.dbsm.models.catalogo;

/**
 *
 * @author Grupo 5
 * --TABLE PAIS
 */
public class Pais {
 
    public Integer ID_PAIS = 0;
    public String PAIS;

    public Pais() {
    }

    public Pais(Integer ID_PAIS, String PAIS) {
        this.ID_PAIS = ID_PAIS;
        this.PAIS = PAIS;
    }

    public Pais(String PAIS) {
        this.PAIS = PAIS;
    }
    
    public Pais(Integer ID_PAIS) {
       this.ID_PAIS = ID_PAIS;
    }
    
    public Integer getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(Integer ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getPAIS() {
        return PAIS;
    }

    public void setPAIS(String PAIS) {
        this.PAIS = PAIS;
    }

}
