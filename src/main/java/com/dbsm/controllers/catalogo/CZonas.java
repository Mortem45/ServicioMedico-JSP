package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Municipios;
import com.dbsm.models.catalogo.Zonas;
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
 * @author Grupo 5
 */
public class CZonas {
    public static boolean db(Zonas zonas) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((zonas.getID_ZONA() == 0 || zonas.getID_ZONA() == null)
                    && zonas.getMUNICIPIO().getID_MUNICIPIO() != 0 && zonas.getMUNICIPIO().getID_MUNICIPIO() != null
                    && zonas.getZONA() != 0 && zonas.getZONA() != null
            ) { //insert
                st.execute(
                        "INSERT INTO ZONAS VALUES (0, "
                        + "" + zonas.getMUNICIPIO().getID_MUNICIPIO() + ", "
                        + "" + zonas.getZONA() + ", "
                        + "SYSDATE, "
                        + "''"
                        + ")"
                );
                status = true;
            } else if (zonas.getID_ZONA() != 0 && zonas.getID_ZONA() != null
                    && zonas.getMUNICIPIO().getID_MUNICIPIO() != 0 && zonas.getMUNICIPIO().getID_MUNICIPIO() != null
                    && zonas.getZONA() != 0 && zonas.getZONA() != null
            ) { //update
                st.execute(
                        "UPDATE ZONAS SET "
                        + "ID_MUNICIPIO = " + zonas.getMUNICIPIO().getID_MUNICIPIO() + ", "
                        + "ZONA = " + zonas.getZONA() + " "
                        + "WHERE ID_ZONA = " + zonas.getID_ZONA()
                );
                status = true;
            } else if (zonas.getID_ZONA() != 0 && zonas.getID_ZONA() != null
                    && (zonas.getMUNICIPIO().getID_MUNICIPIO() == 0 || zonas.getMUNICIPIO().getID_MUNICIPIO() == null)
                    && (zonas.getZONA() == 0 || zonas.getZONA() == null)
            ) { // delete
                st.execute(
                        "DELETE FROM ZONAS WHERE ID_ZONA = " + zonas.getID_ZONA()
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
    
    public static List<Zonas> getAll() throws SQLException {
        List<Zonas> zonas = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stZonas = conn.createStatement();
        ResultSet rZonas = stZonas.executeQuery(
                "SELECT Z.*, M.MUNICIPIO FROM ZONAS Z "
                + "INNER JOIN MUNICIPIO M on Z.ID_MUNICIPIO = M.ID_MUNICIPIO "
                + "ORDER BY M.MUNICIPIO, Z.ZONA"
        );

        while (rZonas.next()) {
            zonas.add(new Zonas(
                    rZonas.getInt("ID_ZONA"),
                    new Municipios(
                            rZonas.getInt("ID_MUNICIPIO"),
                            rZonas.getString("MUNICIPIO")
                    ),
                    rZonas.getInt("ZONA"),
                    rZonas.getDate("FECHA_REGISTRO"),
                    rZonas.getString("USUARIO_REGISTRO")
            ));
        }

        rZonas.close();
        stZonas.close();
        conn.close();

        return zonas;
    }
}
