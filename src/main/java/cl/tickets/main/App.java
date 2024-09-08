package cl.tickets.main;

import cl.tickets.business.Administrador;
import cl.tickets.business.Evento;
import cl.tickets.persistencia.Conexion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Conexion conexion = new Conexion("sistema_ticket.sqlite");
        Administrador adm = new Administrador();
        adm.setUsername("jperez");
        adm.setPassword("(-QF&Q=IN2nFBx");

        // Example for creating a Teatro event
        List<String> actores = new ArrayList<>();
        actores.add("Actor 1");
        actores.add("Actor 2");

        //Creando Eventos con Patrón Factory
        Evento eventoTeatro = adm.crearEvento("teatro", 1, "La pergola de las flores", new Date(), 2, "Juan Perez", actores);
        Evento eventoComedia = adm.crearEvento("comedia", 2, "Comedia Divertida", new Date(), 1, null, null);
        Evento eventoConcierto = adm.crearEvento("concierto", 3, "Gran Concierto", new Date(), 3, null, null);

        adm.guardarAdministrador(conexion);
        eventoTeatro.guardarEvento(conexion);
        eventoComedia.guardarEvento(conexion);
        eventoConcierto.guardarEvento(conexion);
    }
}
