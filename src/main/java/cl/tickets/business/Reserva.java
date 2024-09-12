package cl.tickets.business;

import cl.tickets.persistencia.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Reserva {

    private int id;
    private int cantidad;
    private Date fecha;
    private int precioTotal;
    private String estadoReserva;
    private List<Butaca> butacas;

    // Constructor privado para el patrón Builder
    private Reserva(Builder builder) {
        this.id = builder.id;
        this.cantidad = builder.cantidad;
        this.fecha = builder.fecha;
        this.precioTotal = builder.precioTotal;
        this.estadoReserva = builder.estadoReserva;
        this.butacas = builder.butacas;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public List<Butaca> getButacas() {
        return butacas;
    }

    // Método para guardar la reserva en la base de datos
    public void guardarReserva(Conexion conexion) {
        String sql = "INSERT INTO reserva (id, cantidad, fecha, precio_total, estado_reserva) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setInt(2, this.cantidad);
            pstmt.setDate(3, new java.sql.Date(this.fecha.getTime()));
            pstmt.setInt(4, this.precioTotal);
            pstmt.setString(5, this.estadoReserva);
            pstmt.executeUpdate();
            System.out.println("Reserva guardada correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para cargar una reserva desde la base de datos
    public static Reserva cargarReserva(Conexion conexion, int id) {
        String sql = "SELECT * FROM reserva WHERE id = ?";
        Reserva reserva = null;

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                reserva = new Reserva.Builder(rs.getInt("id"))
                        .setCantidad(rs.getInt("cantidad"))
                        .setFecha(rs.getDate("fecha"))
                        .setPrecioTotal(rs.getInt("precio_total"))
                        .setEstadoReserva(rs.getString("estado_reserva"))
                        .build();
                System.out.println("Reserva cargada correctamente.");
            } else {
                System.out.println("No se encontró ninguna reserva con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reserva;
    }

    // Clase Builder
    public static class Builder {
        private final int id; // Campo obligatorio
        private int cantidad;
        private Date fecha;
        private int precioTotal;
        private String estadoReserva;
        private List<Butaca> butacas;

        // Constructor del Builder con el campo obligatorio id
        public Builder(int id) {
            this.id = id;
        }

        // Métodos para setear los campos opcionales
        public Builder setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder setFecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder setPrecioTotal(int precioTotal) {
            this.precioTotal = precioTotal;
            return this;
        }

        public Builder setEstadoReserva(String estadoReserva) {
            this.estadoReserva = estadoReserva;
            return this;
        }

        public Builder setButacas(List<Butaca> butacas) {
            this.butacas = butacas;
            return this;
        }

        // Método build para crear el objeto Reserva
        public Reserva build() {
            return new Reserva(this);
        }
    }
}
