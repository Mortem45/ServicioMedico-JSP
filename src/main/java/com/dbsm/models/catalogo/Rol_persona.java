package com.dbsm.models.catalogo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 * -- TABLE ROL_PERSONA
 */
public class Rol_persona {
 
    public Integer ID_ROL;
    public String ROL;
    public String ESTADO;
    public String USUARIO_REGISTRO;
    public Date FECHA_REGISTRO;

    public Rol_persona() {
    }

    public Rol_persona(Integer ID_ROL, String ROL, String ESTADO, String USUARIO_REGISTRO, Date FECHA_REGISTRO) {
        this.ID_ROL = ID_ROL;
        this.ROL = ROL;
        this.ESTADO = ESTADO;
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public Integer getID_ROL() {
        return ID_ROL;
    }

    public void setID_ROL(Integer ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }
    
}
