package com.dbsm.controllers.catalogo;

import com.dbsm.config.ConnectionDb;
import com.dbsm.models.catalogo.Enfermedad;
import com.dbsm.models.catalogo.Rol_persona;
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
public class CRol_persona {
    public static boolean db(Rol_persona rol) {
        boolean status = false;
        try {
            Connection conn = ConnectionDb.getInstance().getBds().getConnection();
            Statement st = conn.createStatement();
            if ((rol.getID_ROL() == 0 || rol.getID_ROL() == null)
                && !rol.getROL().equals("") && rol.getROL() != null
                && !rol.getESTADO().equals("") && rol.getESTADO() != null
            ) { //insert
                st.execute(
                        "INSERT INTO ROL_PERSONA VALUES (0, "
                        + "'" + rol.getROL() + "', "
                        + " '" + rol.getESTADO()+ "', "
                        + " '" + rol.getUSUARIO_REGISTRO() + "', "
                        + "SYSDATE"
                        + ")"
                );
                status = true;
            } else if (rol.getID_ROL() != 0 && rol.getID_ROL() != null
                && !rol.getROL().equals("") && rol.getROL() != null
                && !rol.getESTADO().equals("") && rol.getESTADO() != null
            ) { //update
                st.execute(
                        "UPDATE ROL_PERSONA SET "
                        + "ROL = '" + rol.getROL()+ "', "
                        + "ESTADO = '" + rol.getESTADO()+ "' "
                        + "WHERE ID_ROL = " + rol.getID_ROL()
                );

                status = true;
            } else if (rol.getID_ROL() != 0 && rol.getID_ROL() != null
                    && (rol.getROL().equals("") || rol.getROL() == null)
                    && (rol.getESTADO().equals("") || rol.getESTADO() == null)
            ) { // delete
                st.execute(
                        "DELETE FROM ROL_PERSONA WHERE ID_ROL = " + rol.getID_ROL()
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

    public static List<Rol_persona> getAll() throws SQLException {
        List<Rol_persona> rol = new ArrayList<>();
        Connection conn = ConnectionDb.getInstance().getBds().getConnection();
        Statement stRol = conn.createStatement();
        ResultSet rRol = stRol.executeQuery(
                "SELECT * FROM ROL_PERSONA"
        );

        while (rRol.next()) {
            rol.add(new Rol_persona(
                    rRol.getInt("ID_ROL"),
                    rRol.getString("ROL"),
                    rRol.getString("ESTADO"),
                    rRol.getString("USUARIO_REGISTRO"),
                    rRol.getDate("FECHA_REGISTRO")
            ));
        }

        rRol.close();
        stRol.close();
        conn.close();

        return rol;
    }
}
