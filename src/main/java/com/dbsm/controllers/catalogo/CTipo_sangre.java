package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
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
public class CTipo_sangre {
    public static boolean db(Tipo_sangre tipo) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((tipo.getID_TIPO_SANGRE() == 0 || tipo.getID_TIPO_SANGRE() == null)
                    && !tipo.getTIPO_SANGRE().equals("") && tipo.getTIPO_SANGRE() != null) { //insert
                st.execute(
                        "INSERT INTO TIPO_SANGRE VALUES (0, "
                        + "'" + tipo.getTIPO_SANGRE().toUpperCase() + "', "
                        + "''"
                        + ")"
                );
                status = true;
            } else if (tipo.getID_TIPO_SANGRE() != 0 && tipo.getID_TIPO_SANGRE() != null
                    && !tipo.getTIPO_SANGRE().equals("") && tipo.getTIPO_SANGRE() != null) { //update
                st.execute(
                        "UPDATE TIPO_SANGRE SET "
                        + "TIPO_SANGRE = '" + tipo.getTIPO_SANGRE().toUpperCase() + "' "
                        + "WHERE ID_TIPO_SANGRE = " + tipo.getID_TIPO_SANGRE()
                );
                status = true;
            } else if (tipo.getID_TIPO_SANGRE() != 0 && tipo.getID_TIPO_SANGRE() != null
                    && (tipo.getTIPO_SANGRE().equals("") || tipo.getTIPO_SANGRE() == null)) { // delete
                st.execute(
                        "DELETE FROM TIPO_SANGRE WHERE ID_TIPO_SANGRE = " + tipo.getID_TIPO_SANGRE()
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

    public static List<Tipo_sangre> getAll() throws SQLException {
        List<Tipo_sangre> tipo = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stTipo = conn.createStatement();
        ResultSet rTipo = stTipo.executeQuery(
                "SELECT * FROM TIPO_SANGRE"
        );

        while (rTipo.next()) {
            tipo.add(new Tipo_sangre(
                    rTipo.getInt("ID_TIPO_SANGRE"),
                    rTipo.getString("TIPO_SANGRE"),
                    ""
            ));
        }

        rTipo.close();
        stTipo.close();
        conn.close();

        return tipo;
    }
}
