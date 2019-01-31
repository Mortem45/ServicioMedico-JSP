package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Departamento;
import com.dbsm.models.catalogo.Municipios;
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
public class CMunicipios {
    public static boolean db(Municipios municipio) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((municipio.getID_MUNICIPIO() == 0 || municipio.getID_MUNICIPIO() == null)
                    && municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() != 0 && municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() != null
                    && municipio.getPAIS().getID_PAIS() != 0 && municipio.getPAIS().getID_PAIS() != null
                    && !municipio.getMUNICIPIO().equals("") && municipio.getMUNICIPIO() != null
                ) { //insert
                st.execute(
                        "INSERT INTO MUNICIPIO VALUES (0, "
                        + "" + municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() + ", "
                        + "" + municipio.getPAIS().getID_PAIS() + ", "
                        + "'" + municipio.getMUNICIPIO().toUpperCase() + "', "
                        + "SYSDATE "
                        + ")"
                );
                status = true;
            } else if (municipio.getID_MUNICIPIO() != 0 && municipio.getID_MUNICIPIO() != null
                    && municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() != 0 && municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() != null
                    && municipio.getPAIS().getID_PAIS() != 0 && municipio.getPAIS().getID_PAIS() != null
                    && !municipio.getMUNICIPIO().equals("") && municipio.getMUNICIPIO() != null
            ) { //update
                st.execute(
                        "UPDATE MUNICIPIO SET "
                        + "ID_DEPARTAMENTO = " + municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() + ", "
                        + "ID_PAIS = " + municipio.getPAIS().getID_PAIS() + ", "
                        + "MUNICIPIO = '" + municipio.getMUNICIPIO().toUpperCase() + "' "
                        + "WHERE ID_MUNICIPIO = " + municipio.getID_MUNICIPIO()
                );
                status = true;
            } else if (municipio.getID_MUNICIPIO() != 0 && municipio.getID_MUNICIPIO() != null
                    && (municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() == 0 || municipio.getDEPARTAMENTO().getID_DEPARTAMENTO() == null)
                    && (municipio.getPAIS().getID_PAIS() == 0 || municipio.getPAIS().getID_PAIS() == null)
                    && (municipio.getMUNICIPIO().equals("") || municipio.getMUNICIPIO() == null)) { // delete
                st.execute(
                        "DELETE FROM MUNICIPIO WHERE ID_MUNICIPIO = " + municipio.getID_MUNICIPIO()
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
    
    public static List<Municipios> getAll() throws SQLException {
        List<Municipios> municipios = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stMunicipio = conn.createStatement();
        ResultSet rMnicipio = stMunicipio.executeQuery(
                "SELECT M.*, D.DEPARTAMENTO FROM MUNICIPIO M "
                + "INNER JOIN DEPARTAMENTO D ON D.ID_DEPARTAMENTO = M.ID_DEPARTAMENTO "
                + "ORDER BY M.MUNICIPIO"
        );

        while (rMnicipio.next()) {
            municipios.add(new Municipios(
                    rMnicipio.getInt("ID_MUNICIPIO"),
                    new Departamento(
                        rMnicipio.getInt("ID_DEPARTAMENTO"),
                        rMnicipio.getString("DEPARTAMENTO")
                    ),
                    new Pais(
                        rMnicipio.getInt("ID_PAIS")
                    ),
                    rMnicipio.getString("MUNICIPIO"),
                    rMnicipio.getDate("FECHA_REGISTRO")
            ));
        }

        rMnicipio.close();
        stMunicipio.close();
        conn.close();

        return municipios;
    }

    public static List<Municipios> getMunicipiosByDepartamento(Integer idDepartamento) throws SQLException {
        List<Municipios> municipios = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stMunicipio = conn.createStatement();
        ResultSet rMnicipio = stMunicipio.executeQuery(
                "SELECT M.*, D.DEPARTAMENTO FROM MUNICIPIO M "
                + "INNER JOIN DEPARTAMENTO D ON D.ID_DEPARTAMENTO = M.ID_DEPARTAMENTO "
                + "WHERE D.ID_DEPARTAMENTO = " + idDepartamento + " "
                + "ORDER BY M.MUNICIPIO"
        );

        while (rMnicipio.next()) {
            municipios.add(new Municipios(
                    rMnicipio.getInt("ID_MUNICIPIO"),
                    new Departamento(
                            rMnicipio.getInt("ID_DEPARTAMENTO"),
                            rMnicipio.getString("DEPARTAMENTO")
                    ),
                    new Pais(
                            rMnicipio.getInt("ID_PAIS")
                    ),
                    rMnicipio.getString("MUNICIPIO"),
                    rMnicipio.getDate("FECHA_REGISTRO")
            ));
        }

        rMnicipio.close();
        stMunicipio.close();
        conn.close();

        return municipios;
    }
}
