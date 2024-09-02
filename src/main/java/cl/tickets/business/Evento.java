package cl.tickets.business;

import cl.tickets.persistencia.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Evento {

    private int id;
    private String nombre;
    private Date fecha;
    private int duracion;
    private List<Butaca> butacas;

    public Evento(int id, String nombre, Date fecha, int duracion) {

        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDuracionDias() {
        return duracion;
    }

    public void setDuracionDias(int duracion) {
        this.duracion = duracion;
    }

    public void guardarEvento(Conexion conexion) {
        String sql = "INSERT INTO evento(id, nombre, fecha, duracion) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1,this.id);
            pstmt.setString(2, this.nombre);
            pstmt.setString(3, this.fecha.toString());
            pstmt.setString(4, String.valueOf(this.duracion));
            pstmt.executeUpdate();
            System.out.println("Evento guardado: " + nombre);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
