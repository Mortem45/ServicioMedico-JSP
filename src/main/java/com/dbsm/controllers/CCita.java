package com.dbsm.controllers;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.Cita;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * CCita
 */
public class CCita {

  public static boolean db (Cita cita) {
    boolean status = false;
    try {
      Connection conn = ConnectionDb.getInstance().getBds().getConnection();
      Statement st = conn.createStatement();
      if ((cita.getID_CITA() == 0 || cita.getID_CITA() == null)
                    && !cita.getCITA().equals("") && cita.getCITA() != null
            ){
              //insert
              st.execute(
                "INSERT INTO CITA VALUES (0, "
                + cita.getID_CITA() + ","
                + cita.getID_PERSONA_PACIENTE() + ","
                +  "'" + cita.getCITA() + "'" + ","
                + "SYSDATE" + ","
                + "'" + cita.getUSUARIO_REGISTRO() + "'" + ","
                + cita.getFECHA_CITA().getDate() + ","
                + cita.getFECHA_CITA().getHours() + ","
                + ")"
              );
              status = true;
      } else if ((cita.getID_CITA() == 0 || cita.getID_CITA() == null)
                  && !cita.getCITA().equals("") && cita.getCITA() != null){
        st.execute(
          "UPDATE CITA SET "
          + "ID_CITA = " + cita.getID_CITA() + ", "
          + "ID_SEGURO = " + cita.getID_SEGURO() + ", "
          + "ID_PERSONA_PACIENTE = " + cita.getID_PERSONA_PACIENTE() + ", "
          + "CITA = '" + cita.getCITA() + "' "+ ", "
          + "FECHA_REGISTRO = '" + "SYSDATE" + "' " + ", "
          + "USUARIO_REGISTRO = '" + cita.getUSUARIO_REGISTRO() + "' "+ ", "
          + "FECHA_CITA = " + cita.getFECHA_CITA().getDate() + ", "
          + "HORA_CITA = " + cita.getFECHA_CITA().getHours() + ", "
          + "WHERE ID_CITA = " + cita.getID_CITA()
          );
          status = true;
      } else if ((cita.getID_CITA() == 0 || cita.getID_CITA() == null)
                  && !cita.getCITA().equals("") && cita.getCITA() != null){
        st.execute(
          "DELETE FROM CITA WHERE ID_CITA = " + cita.getID_CITA()
      );
      status = true;
    }
    st.close();
    conn.close();
    } catch (Exception ex) {
      Logger.getLogger(CCita.class.getName()).log(Level.SEVERE, null, ex);
    }
    return status;
  }

  public static List<Cita> getAll() throws SQLException {
    List<Cita> cita = new ArrayList<>();
    Connection conn = ConnectionDb.getInstance().getBds().getConnection();
    Statement stCita = conn.createStatement();
    ResultSet rCita = stCita.executeQuery(
            "SELECT * FROM CITA"
    );

    while (rCita.next()) {
        cita.add(new Cita(
                rCita.getInt("ID_CITA"),
                rCita.getString("CITA")
        ));
    }

    rCita.close();
    stCita.close();
    conn.close();

    return cita;
}

}



