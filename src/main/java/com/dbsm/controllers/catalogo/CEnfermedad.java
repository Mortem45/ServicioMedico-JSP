package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Enfermedad;
import com.dbsm.models.catalogo.Tipo_enfermedad;
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
public class CEnfermedad {
    public static boolean db(Enfermedad enfermedad) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((enfermedad.getID_ENFERMEDAD() == 0 || enfermedad.getID_ENFERMEDAD() == null)
                && enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() != 0 && enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() != null
                && !enfermedad.getENFERMEDAD().equals("") && enfermedad.getENFERMEDAD() != null
                && !enfermedad.getDESCRIPCION().equals("") && enfermedad.getDESCRIPCION() != null
                && !enfermedad.getSOLUCION().equals("") && enfermedad.getSOLUCION() != null
            ) { //insert
                st.execute(
                        "INSERT INTO ENFERMEDAD VALUES (0, "
                        + "" + enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() + ", "
                        + "'" + enfermedad.getENFERMEDAD() + "', "
                        + "'', "
                        + " '" + enfermedad.getDESCRIPCION() + "', "
                        + " '" + enfermedad.getSOLUCION() + "', "
                        + "SYSDATE"
                        + ")"
                );
                status = true;
            } else if (enfermedad.getID_ENFERMEDAD() != 0 && enfermedad.getID_ENFERMEDAD() != null
                    && enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() != 0 && enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() != null
                    && !enfermedad.getENFERMEDAD().equals("") && enfermedad.getENFERMEDAD() != null
                    && !enfermedad.getDESCRIPCION().equals("") && enfermedad.getDESCRIPCION() != null
                    && !enfermedad.getSOLUCION().equals("") && enfermedad.getSOLUCION() != null
            ) { //update
                st.execute(
                        "UPDATE ENFERMEDAD SET "
                        + "TIPO_ENFERMEDAD = " + enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() + ", "
                        + "ENFERMEDAD = '" + enfermedad.getENFERMEDAD() + "', "
                        + "DESCRIPCION = '" + enfermedad.getDESCRIPCION() + "', "
                        + "SOLUCION = '" + enfermedad.getSOLUCION() + "' "
                        + "WHERE ID_ENFERMEDAD = " + enfermedad.getID_ENFERMEDAD()
                );
                
                status = true;
            } else if (enfermedad.getID_ENFERMEDAD() != 0 && enfermedad.getID_ENFERMEDAD() != null
                    && (enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() == 0 || enfermedad.getTIPO_ENFERMEDAD().getID_TIPO_ENFERMEDAD() == null)
                    && (enfermedad.getENFERMEDAD().equals("") || enfermedad.getENFERMEDAD() == null)
                    && (enfermedad.getDESCRIPCION().equals("") || enfermedad.getDESCRIPCION() == null)
                    && (enfermedad.getSOLUCION().equals("") || enfermedad.getSOLUCION() == null)
            ) { // delete
                st.execute(
                    "DELETE FROM ENFERMEDAD WHERE ID_ENFERMEDAD = " + enfermedad.getID_ENFERMEDAD()
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

    public static List<Enfermedad> getAll() throws SQLException {
        List<Enfermedad> enfermedad = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stEnfermedad = conn.createStatement();
        ResultSet rEnfermedad = stEnfermedad.executeQuery(
            "SELECT E.*, T.TIPO_ENFERMEDAD FROM ENFERMEDAD E "
            + "INNER JOIN TIPO_ENFERMEDAD T ON E.ID_TIPO_ENFERMEDAD = T.ID_TIPO_ENFERMEDAD"
        );

        while (rEnfermedad.next()) {
            enfermedad.add(new Enfermedad(
                    rEnfermedad.getInt("ID_ENFERMEDAD"),
                    new Tipo_enfermedad(
                        rEnfermedad.getInt("ID_TIPO_ENFERMEDAD"),
                        rEnfermedad.getString("TIPO_ENFERMEDAD")
                    ),
                    rEnfermedad.getString("ENFERMEDAD"),
                    rEnfermedad.getInt("USUARIO_REGISTRO"),
                    rEnfermedad.getString("DESCRIPCION"),
                    rEnfermedad.getString("SOLUCION"),
                    rEnfermedad.getDate("FECHA_REGISTRO")
            ));
        }

        rEnfermedad.close();
        stEnfermedad.close();
        conn.close();

        return enfermedad;
    }
}
