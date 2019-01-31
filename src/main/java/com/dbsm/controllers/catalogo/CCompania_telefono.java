package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Colonia;
import com.dbsm.models.catalogo.Compania_telefono;
import com.dbsm.models.catalogo.Municipios;
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
public class CCompania_telefono {
    public static boolean db(Compania_telefono compania) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((compania.getID_COMPANIA() == 0 || compania.getID_COMPANIA() == null)
                    && !compania.getCOMPANIA().equals("") && compania.getCOMPANIA() != null
            ) { //insert
                st.execute(
                        "INSERT INTO COMPANIA_TELEFONO VALUES (0, "
                        + "'" + compania.getCOMPANIA().toUpperCase() + "'"
                        + ")"
                );
                status = true;
            } else if (compania.getID_COMPANIA() != 0 && compania.getID_COMPANIA() != null
                    && !compania.getCOMPANIA().equals("") && compania.getCOMPANIA() != null
            ) { //update
                st.execute(
                        "UPDATE COMPANIA_TELEFONO SET "
                        + "COMPANIA = '" + compania.getCOMPANIA().toUpperCase() + "' "
                        + "WHERE ID_COMPANIA = " + compania.getID_COMPANIA()
                );
                status = true;
            } else if (compania.getID_COMPANIA() != 0 && compania.getID_COMPANIA() != null
                    && (compania.getCOMPANIA().equals("") || compania.getCOMPANIA() == null)
            ) { // delete
                st.execute(
                        "DELETE FROM COMPANIA_TELEFONO WHERE ID_COMPANIA = " + compania.getID_COMPANIA()
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

    public static List<Compania_telefono> getAll() throws SQLException {
        List<Compania_telefono> compania = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stCompania = conn.createStatement();
        ResultSet rCompania = stCompania.executeQuery(
                "SELECT * FROM COMPANIA_TELEFONO"
        );

        while (rCompania.next()) {
            compania.add(new Compania_telefono(
                    rCompania.getInt("ID_COMPANIA"),
                    rCompania.getString("COMPANIA")
            ));
        }

        rCompania.close();
        stCompania.close();
        conn.close();

        return compania;
    }
}
