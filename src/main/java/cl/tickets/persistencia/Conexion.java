package cl.tickets.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conn;

    public Conexion(String dbName) {
        try {
            String url = "jdbc:sqlite:" + dbName;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con la base de datos: " + dbName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}