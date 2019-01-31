package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Tipo_enfermedad;
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
public class CTipo_enfermedad {
    public static boolean db(Tipo_enfermedad tipo) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((tipo.getID_TIPO_ENFERMEDAD() == 0 || tipo.getID_TIPO_ENFERMEDAD() == null)
                    && !tipo.getTIPO_ENFERMEDAD().equals("") && tipo.getTIPO_ENFERMEDAD() != null) { //insert
                st.execute(
                        "INSERT INTO TIPO_ENFERMEDAD VALUES (0, "
                        + "'" + tipo.getTIPO_ENFERMEDAD().toUpperCase() + "', "
                        + "'',"
                        + "SYSDATE"
                        + ")"
                );
                status = true;
            } else if (tipo.getID_TIPO_ENFERMEDAD() != 0 && tipo.getID_TIPO_ENFERMEDAD() != null
                    && !tipo.getTIPO_ENFERMEDAD().equals("") && tipo.getTIPO_ENFERMEDAD() != null) { //update
                st.execute(
                        "UPDATE TIPO_ENFERMEDAD SET "
                        + "TIPO_ENFERMEDAD = '" + tipo.getTIPO_ENFERMEDAD().toUpperCase() + "' "
                        + "WHERE ID_TIPO_ENFERMEDAD = " + tipo.getID_TIPO_ENFERMEDAD()
                );
                status = true;
            } else if (tipo.getID_TIPO_ENFERMEDAD() != 0 && tipo.getID_TIPO_ENFERMEDAD() != null
                    && (tipo.getTIPO_ENFERMEDAD().equals("") || tipo.getTIPO_ENFERMEDAD() == null)) { // delete
                st.execute(
                        "DELETE FROM TIPO_ENFERMEDAD WHERE ID_TIPO_ENFERMEDAD = " + tipo.getID_TIPO_ENFERMEDAD()
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

    public static List<Tipo_enfermedad> getAll() throws SQLException {
        List<Tipo_enfermedad> tipo = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stTipo = conn.createStatement();
        ResultSet rTipo = stTipo.executeQuery(
                "SELECT * FROM TIPO_ENFERMEDAD"
        );

        while (rTipo.next()) {
            tipo.add(new Tipo_enfermedad(
                    rTipo.getInt("ID_TIPO_ENFERMEDAD"),
                    rTipo.getString("TIPO_ENFERMEDAD"),
                    0,
                    rTipo.getDate("FECHA_REGISTRO")
            ));
        }

        rTipo.close();
        stTipo.close();
        conn.close();

        return tipo;
    }
}
