package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Departamento;
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
 * @author Grupo 5
 */
public class CDepartamento {
    public static boolean db(Departamento departamento) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((departamento.getID_DEPARTAMENTO() == 0 || departamento.getID_DEPARTAMENTO() == null)
                    && departamento.getPAIS().getID_PAIS() != 0 && departamento.getPAIS().getID_PAIS() != null
                    && !departamento.getDEPARTAMENTO().equals("") && departamento.getDEPARTAMENTO() != null
            ) { //insert
                st.execute(
                        "INSERT INTO DEPARTAMENTO VALUES (0, "
                        + "" + departamento.getPAIS().getID_PAIS() + ", "
                        + "'" + departamento.getDEPARTAMENTO().toUpperCase() + "', "
                        + "SYSDATE "
                        + ")"
                );
                status = true;
            } else if (departamento.getID_DEPARTAMENTO() != 0 && departamento.getID_DEPARTAMENTO() != null
                    && departamento.getPAIS().getID_PAIS() != 0 && departamento.getPAIS().getID_PAIS() != null
                    && !departamento.getDEPARTAMENTO().equals("") && departamento.getDEPARTAMENTO() != null
            ) { //update
                st.execute(
                        "UPDATE DEPARTAMENTO SET "
                        + "ID_PAIS = " + departamento.getPAIS().getID_PAIS() + ", "
                        + "DEPARTAMENTO = '" + departamento.getDEPARTAMENTO().toUpperCase() + "' "
                        + "WHERE ID_DEPARTAMENTO = " + departamento.getID_DEPARTAMENTO()
                );
                status = true;
            } else if (departamento.getID_DEPARTAMENTO() != 0 && departamento.getID_DEPARTAMENTO() != null
                    && (departamento.getPAIS().getID_PAIS() == 0 || departamento.getPAIS().getID_PAIS() == null)
                    && (departamento.getDEPARTAMENTO().equals("") || departamento.getDEPARTAMENTO() == null)
            ) { // delete
                st.execute(
                    "DELETE FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO = " + departamento.getID_DEPARTAMENTO()
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

    public static List<Departamento> getAll() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stDepartamento = conn.createStatement();
        ResultSet rDepartamento = stDepartamento.executeQuery(
                "SELECT D.*, P.PAIS FROM DEPARTAMENTO D "
                + "INNER JOIN PAIS P ON P.ID_PAIS = D.ID_PAIS "
                + "ORDER BY DEPARTAMENTO"
        );

        while (rDepartamento.next()) {
            departamentos.add(new Departamento(
                    rDepartamento.getInt("ID_DEPARTAMENTO"),
                    new Pais(
                            rDepartamento.getInt("ID_PAIS"), 
                            rDepartamento.getString("PAIS")
                    ),
                    rDepartamento.getString("DEPARTAMENTO"),
                    rDepartamento.getDate("FECHA_REGISTRO")
            ));
        }
        
        rDepartamento.close();
        stDepartamento.close();
        conn.close();
        
        return departamentos;
    }
    
    public static List<Departamento> getDepartamentosByPais(Integer idPais) throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stDepartamento = conn.createStatement();
        ResultSet rDepartamento = stDepartamento.executeQuery(
            "SELECT D.*, P.PAIS FROM DEPARTAMENTO D "
            + "INNER JOIN PAIS P ON P.ID_PAIS = D.ID_PAIS "
            + "WHERE D.ID_PAIS = " + idPais + " "
            + "ORDER BY DEPARTAMENTO"
        );

        while (rDepartamento.next()) {
            departamentos.add(new Departamento(
                    rDepartamento.getInt("ID_DEPARTAMENTO"),
                    new Pais(
                            rDepartamento.getInt("ID_PAIS"),
                            rDepartamento.getString("PAIS")
                    ),
                    rDepartamento.getString("DEPARTAMENTO"),
                    rDepartamento.getDate("FECHA_REGISTRO")
            ));
        }

        rDepartamento.close();
        stDepartamento.close();
        conn.close();

        return departamentos;
    }
}
