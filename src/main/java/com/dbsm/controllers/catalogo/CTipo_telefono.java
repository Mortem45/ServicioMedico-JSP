package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Compania_telefono;
import com.dbsm.models.catalogo.Tipo_telefono;
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
 * @author grrupo 5
 */
public class CTipo_telefono {
    public static boolean db(Tipo_telefono tipo) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((tipo.getID_TIPO_TELEFONO() == 0 || tipo.getID_TIPO_TELEFONO() == null)
                    && !tipo.getTIPO_TELEFONO().equals("") && tipo.getTIPO_TELEFONO() != null) { //insert
                st.execute(
                        "INSERT INTO TIPO_TELEFONO VALUES (0, "
                        + "'" + tipo.getTIPO_TELEFONO().toUpperCase() + "'"
                        + ")"
                );
                status = true;
            } else if (tipo.getID_TIPO_TELEFONO() != 0 && tipo.getID_TIPO_TELEFONO() != null
                    && !tipo.getTIPO_TELEFONO().equals("") && tipo.getTIPO_TELEFONO() != null) { //update
                st.execute(
                        "UPDATE TIPO_TELEFONO SET "
                        + "TIPO_TELEFONO = '" + tipo.getTIPO_TELEFONO().toUpperCase() + "' "
                        + "WHERE ID_TIPO_TELEFONO = " + tipo.getID_TIPO_TELEFONO()
                );
                status = true;
            } else if (tipo.getID_TIPO_TELEFONO() != 0 && tipo.getID_TIPO_TELEFONO() != null
                    && (tipo.getTIPO_TELEFONO().equals("") || tipo.getTIPO_TELEFONO() == null)) { // delete
                st.execute(
                        "DELETE FROM TIPO_TELEFONO WHERE ID_TIPO_TELEFONO = " + tipo.getID_TIPO_TELEFONO()
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

    public static List<Tipo_telefono> getAll() throws SQLException {
        List<Tipo_telefono> tipo = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stTipo = conn.createStatement();
        ResultSet rTipo = stTipo.executeQuery(
                "SELECT * FROM TIPO_TELEFONO"
        );

        while (rTipo.next()) {
            tipo.add(new Tipo_telefono(
                    rTipo.getInt("ID_TIPO_TELEFONO"),
                    rTipo.getString("TIPO_TELEFONO")
            ));
        }

        rTipo.close();
        stTipo.close();
        conn.close();

        return tipo;
    }
}
