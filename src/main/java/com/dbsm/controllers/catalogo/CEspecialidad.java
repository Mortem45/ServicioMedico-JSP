package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Especialidad;
import com.dbsm.models.catalogo.Tipo_sangre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grupo 5
 */
public class CEspecialidad {
    public static boolean db(Especialidad especialidad) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((especialidad.getID_ESPECIALIDAD() == 0 || especialidad.getID_ESPECIALIDAD() == null)
                    && !especialidad.getESPECIALIDAD().equals("") && especialidad.getESPECIALIDAD() != null) { //insert
                st.execute(
                    "INSERT INTO ESPECIALIDAD VALUES (0, "
                    + "'" + especialidad.getESPECIALIDAD().toUpperCase() + "'"
                    + ")"
                );
                status = true;
            } else if (especialidad.getID_ESPECIALIDAD() != 0 && especialidad.getID_ESPECIALIDAD() != null
                    && !especialidad.getESPECIALIDAD().equals("") && especialidad.getESPECIALIDAD() != null) { //update
                st.execute(
                    "UPDATE ESPECIALIDAD SET "
                    + "ESPECIALIDAD = '" + especialidad.getESPECIALIDAD().toUpperCase() + "' "
                    + "WHERE ID_ESPECIALIDAD = " + especialidad.getID_ESPECIALIDAD()
                );
                status = true;
            } else if (especialidad.getID_ESPECIALIDAD() != 0 && especialidad.getID_ESPECIALIDAD() != null
                    && (especialidad.getESPECIALIDAD().equals("") || especialidad.getESPECIALIDAD() == null)) { // delete
                st.execute(
                    "DELETE FROM ESPECIALIDAD WHERE ID_ESPECIALIDAD = " + especialidad.getID_ESPECIALIDAD()
                );
                status = true;
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPais.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<Especialidad> getAll() throws SQLException {
        List<Especialidad> especialidad = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stEspecialidad = conn.createStatement();
        ResultSet rEspecialidad = stEspecialidad.executeQuery(
                "SELECT * FROM ESPECIALIDAD"
        );

        while (rEspecialidad.next()) {
            especialidad.add(new Especialidad(
                    rEspecialidad.getInt("ID_ESPECIALIDAD"),
                    rEspecialidad.getString("ESPECIALIDAD")
            ));
        }

        rEspecialidad.close();
        stEspecialidad.close();
        conn.close();

        return especialidad;
    }
}
