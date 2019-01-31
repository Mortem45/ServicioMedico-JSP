package com.dbsm.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Grupo 5
 */
public class ConnectionDb {
 
    private static BasicDataSource bs = null;
    private DataSource dataSource;
    private static Connection conn = null;
    
    private static final String DATABASE = "XE";
    private static final String SERVER = "localhost";
    private static final String PORT = "1521";
    private static final String USERNAME = "PDB1";
    private static final String PASSWORD = "PDB1";

    private BasicDataSource bds = new BasicDataSource();

    private ConnectionDb() {
        bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        bds.setUrl("jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + DATABASE);
        bds.setUsername(USERNAME);
        bds.setPassword(PASSWORD);
        bds.setInitialSize(5);
        /* conexiones disponibles cuando se inicia la app*/
        bds.setMinIdle(5);
        /*mínimo de conexiones que se pueden tener en espera a ser utilizadas*/
        bds.setLifo(false);
        /*Las conexiones funcionan como una cola FIFO, 
                              si es verdadero siempre tratara de obtener la ultima conexión utilizada*/
//        bds.setMaxConnLifetimeMillis(2000);
    }

    private static class connectionDbHolder {

        private static final ConnectionDb INSTANCE = new ConnectionDb();
    }

    public static ConnectionDb getInstance() {
        return connectionDbHolder.INSTANCE;
    }

    public BasicDataSource getBds() {
        return bds;
    }

    public void setBds(BasicDataSource bds) {
        this.bds = bds;
    }
}
