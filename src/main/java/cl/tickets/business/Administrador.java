package cl.tickets.business;

import cl.tickets.persistencia.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.util.Date;

public class Administrador extends Usuario{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Evento crearEvento(String tipo){

        if (tipo.equals("teatro"))
            return new Evento(1,"La pergola de las flores",new Date(),2);
        else
            return null;
    }

    // Método para crear eventos mediante patrón Factory
    public Evento crearEvento(String tipo, int id, String nombre, Date fecha, int duracion, String director, List<String> actores) {
        return EventoFactory.crearEvento(tipo, id, nombre, fecha, duracion, director, actores);
    }

    public void guardarAdministrador(Conexion conexion) {
        String sql = "INSERT INTO administrador(username, password) VALUES(?,?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, this.username);
            pstmt.setString(2, this.password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
