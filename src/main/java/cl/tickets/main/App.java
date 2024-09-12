package cl.tickets.main;

import cl.tickets.business.Administrador;
import cl.tickets.business.Evento;
import cl.tickets.persistencia.Conexion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Obtener la instancia única de la conexión
        Conexion conexion = Conexion.getInstance("sistema_ticket.sqlite");

        Administrador adm = new Administrador();
        adm.setUsername("jperez");
        adm.setPassword("(-QF&Q=IN2nFBx");

        // Ejemplo de creación de un evento de Teatro
        List<String> actores = new ArrayList<>();
        actores.add("Actor 1");
        actores.add("Actor 2");
        /*
        Creando eventos con el patrón Factory
        Evento eventoTeatro = adm.crearEvento("teatro", 4, "La pérgola de las flores", new Date(), 2, "Juan Perez", actores);
        Evento eventoComedia = adm.crearEvento("comedia", 5, "Comedia Divertida", new Date(), 1, null, null);
        Evento eventoConcierto = adm.crearEvento("concierto", 6, "Gran Concierto", new Date(), 3, null, null);
        */

        // Guardar los datos en la base de datos
        adm.guardarAdministrador(conexion);

        /*
        eventoTeatro.guardarEvento(conexion);
        eventoComedia.guardarEvento(conexion);
        eventoConcierto.guardarEvento(conexion);
        */

        // Cerrar la conexión al final
        conexion.close();
    }
}
