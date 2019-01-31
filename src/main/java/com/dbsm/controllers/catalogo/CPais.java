package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Pais;
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
 * @author GRUPO 5
 */
public class CPais {
    
    public static boolean db(Pais pais) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((pais.getID_PAIS() == 0 || pais.getID_PAIS() == null)
                    && !pais.getPAIS().equals("") && pais.getPAIS() != null) { //insert
                st.execute(
                        "INSERT INTO PAIS VALUES (0, "
                        + "'" + pais.getPAIS().toUpperCase() + "')"
                );
                status = true;
            } else if(pais.getID_PAIS() != 0 && pais.getID_PAIS() != null
                    && !pais.getPAIS().equals("") && pais.getPAIS() != null) { //update
                st.execute(
                    "UPDATE PAIS SET PAIS = '" + pais.getPAIS().toUpperCase() + "'"
                    + "WHERE ID_PAIS = " + pais.getID_PAIS()
                );
                status = true;
            } else if (pais.getID_PAIS() != 0 && pais.getID_PAIS() != null
                    && (pais.getPAIS().equals("") || pais.getPAIS() == null)) { // delete
                st.execute("DELETE FROM PAIS WHERE ID_PAIS = " + pais.getID_PAIS());
                status = true;
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CPais.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return status;
    }
    
    public static List<Pais> getAll() throws SQLException {
        List<Pais> paises = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stPais = conn.createStatement();
        ResultSet rPais = stPais.executeQuery(
            "SELECT * FROM PAIS ORDER BY PAIS"
        );
        
        while (rPais.next()) {
            paises.add(new Pais(
                    rPais.getInt("ID_PAIS"), 
                    rPais.getString("PAIS")
            ));
        }
        
        rPais.close();
        stPais.close();
        conn.close();
        
        return paises;
    }
}
