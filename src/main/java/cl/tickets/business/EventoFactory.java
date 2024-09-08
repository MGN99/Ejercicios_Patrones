// EventoFactory.java
package cl.tickets.business;

import java.util.Date;
import java.util.List;

public class EventoFactory {

    public static Evento crearEvento(String tipo, int id, String nombre, Date fecha, int duracion, String director, List<String> actores) {
        switch (tipo.toLowerCase()) {
            case "teatro":
                return new Teatro(id, nombre, fecha, duracion, director, actores);
            case "comedia":
                return new Comedia(id, nombre, fecha, duracion);  // No need for director or actors here
            case "concierto":
                return new Concierto(id, nombre, fecha, duracion);  // Director is optional, can be set later
            default:
                throw new IllegalArgumentException("Tipo de evento desconocido: " + tipo);
        }
    }
}
