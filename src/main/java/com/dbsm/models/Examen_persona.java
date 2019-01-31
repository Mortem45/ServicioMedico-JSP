package com.dbsm.models;

/**
 *
 * @author Grupo 5
 * --TABLE EXAMEN_PERSONA
 */
public class Examen_persona {
 
    public Integer ID_PERSONA;
    public Integer ID_EXAMEN;
    public String RESULTADO;

    public Examen_persona(Integer ID_PERSONA, Integer ID_EXAMEN, String RESULTADO) {
        this.ID_PERSONA = ID_PERSONA;
        this.ID_EXAMEN = ID_EXAMEN;
        this.RESULTADO = RESULTADO;
    }

    public Integer getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(Integer ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public Integer getID_EXAMEN() {
        return ID_EXAMEN;
    }

    public void setID_EXAMEN(Integer ID_EXAMEN) {
        this.ID_EXAMEN = ID_EXAMEN;
    }

    public String getRESULTADO() {
        return RESULTADO;
    }

    public void setRESULTADO(String RESULTADO) {
        this.RESULTADO = RESULTADO;
    }
    
    
}