package cl.tickets.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance; // Instancia Singleton
    private Connection conn;

    // Constructor privado para evitar instancias externas
    private Conexion(String dbName) {
        try {
            String url = "jdbc:sqlite:" + dbName;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con la base de datos: " + dbName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para obtener la única instancia de la clase
    public static synchronized Conexion getInstance(String dbName) {
        if (instance == null) {
            instance = new Conexion(dbName);
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return conn;
    }

    // Método para cerrar la conexión
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
