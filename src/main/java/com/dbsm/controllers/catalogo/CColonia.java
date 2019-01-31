package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Colonia;
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
public class CColonia {
    public static boolean db(Colonia colonia) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((colonia.getID_COLONIA() == 0 || colonia.getID_COLONIA() == null)
                    && colonia.getMUNICIPIO().getID_MUNICIPIO() != 0 && colonia.getMUNICIPIO().getID_MUNICIPIO() != null
                    && !colonia.getCOLONIA().equals("") && colonia.getCOLONIA() != null
            ) { //insert
                st.execute(
                        "INSERT INTO COLONIA VALUES (0, "
                        + "" + colonia.getMUNICIPIO().getID_MUNICIPIO() + ", "
                        + "'" + colonia.getCOLONIA() + "'"
                        + ")"
                );
                status = true;
            } else if (colonia.getID_COLONIA()!= 0 && colonia.getID_COLONIA() != null
                    && colonia.getMUNICIPIO().getID_MUNICIPIO() != 0 && colonia.getMUNICIPIO().getID_MUNICIPIO() != null
                    && !colonia.getCOLONIA().equals("") && colonia.getCOLONIA() != null
            ) { //update
                st.execute(
                        "UPDATE COLONIA SET "
                        + "ID_MUNICIPIO = " + colonia.getMUNICIPIO().getID_MUNICIPIO() + ", "
                        + "COLONIA = '" + colonia.getCOLONIA() + "' "
                        + "WHERE ID_COLONIA = " + colonia.getID_COLONIA()
                );
                status = true;
            } else if (colonia.getID_COLONIA() != 0 && colonia.getID_COLONIA() != null
                    && (colonia.getMUNICIPIO().getID_MUNICIPIO() == 0 || colonia.getMUNICIPIO().getID_MUNICIPIO() == null)
                    && (colonia.getCOLONIA().equals("") || colonia.getCOLONIA() == null)
                    ) { // delete
                st.execute(
                        "DELETE FROM COLONIA WHERE ID_COLONIA = " + colonia.getID_COLONIA()
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

    public static List<Colonia> getAll() throws SQLException {
        List<Colonia> colonia = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stColonia = conn.createStatement();
        ResultSet rColonia = stColonia.executeQuery(
                "SELECT C.*, M.MUNICIPIO FROM COLONIA C "
                + "INNER JOIN MUNICIPIO M ON C.ID_MUNICIPIO = M.ID_MUNICIPIO "
                + "ORDER BY M.MUNICIPIO, C.COLONIA"
        );

        while (rColonia.next()) {
            colonia.add(new Colonia(
                    rColonia.getInt("ID_COLONIA"),
                    new Municipios(
                            rColonia.getInt("ID_MUNICIPIO"),
                            rColonia.getString("MUNICIPIO")
                    ),
                    rColonia.getString("COLONIA")
            ));
        }

        rColonia.close();
        stColonia.close();
        conn.close();

        return colonia;
    }
    
    public static List<Colonia> getAllByMunicipio(Integer idMunicipio) throws SQLException {
        List<Colonia> colonia = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stColonia = conn.createStatement();
        ResultSet rColonia = stColonia.executeQuery(
                "SELECT C.*, M.MUNICIPIO FROM COLONIA C "
                + "INNER JOIN MUNICIPIO M ON C.ID_MUNICIPIO = M.ID_MUNICIPIO "
                + "WHERE M.ID_MUNICIPIO = " + idMunicipio + " "
                + "ORDER BY M.MUNICIPIO, C.COLONIA"
        );

        while (rColonia.next()) {
            colonia.add(new Colonia(
                    rColonia.getInt("ID_COLONIA"),
                    new Municipios(
                            rColonia.getInt("ID_MUNICIPIO"),
                            rColonia.getString("MUNICIPIO")
                    ),
                    rColonia.getString("COLONIA")
            ));
        }

        rColonia.close();
        stColonia.close();
        conn.close();

        return colonia;
    }
}
