package cl.tickets.main;

import cl.tickets.business.Administrador;
import cl.tickets.business.Evento;
import cl.tickets.persistencia.Conexion;

public class App {

    public static void main (String[]args){

        Conexion conexion = new Conexion("sistema_ticket.sqlite");
        Administrador adm = new Administrador();
        adm.setUsername("jperez");
        adm.setPassword("(-QF&Q=IN2nFBx");
        Evento evento = adm.crearEvento("teatro");

        adm.guardarAdministrador(conexion);
        evento.guardarEvento(conexion);

    }
}
