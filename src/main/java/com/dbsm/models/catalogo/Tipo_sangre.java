package com.dbsm.models.catalogo;

/**
 *
 * @author Grupo 5
 * --TABLE TIPO_SANGRE
 */
public class Tipo_sangre {
 
    public Integer ID_TIPO_SANGRE;
    public String TIPO_SANGRE;
    public String USUARIO_REGISTRO;

    public Tipo_sangre() {
    }

    public Tipo_sangre(Integer ID_TIPO_SANGRE, String TIPO_SANGRE, String USUARIO_REGISTRO) {
        this.ID_TIPO_SANGRE = ID_TIPO_SANGRE;
        this.TIPO_SANGRE = TIPO_SANGRE;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }

    public Integer getID_TIPO_SANGRE() {
        return ID_TIPO_SANGRE;
    }

    public void setID_TIPO_SANGRE(Integer ID_TIPO_SANGRE) {
        this.ID_TIPO_SANGRE = ID_TIPO_SANGRE;
    }

    public String getTIPO_SANGRE() {
        return TIPO_SANGRE;
    }

    public void setTIPO_SANGRE(String TIPO_SANGRE) {
        this.TIPO_SANGRE = TIPO_SANGRE;
    }

    public String getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }

}
