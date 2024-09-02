package cl.tickets.business;

import java.util.Date;

public class Comedia extends Evento{

    private String comediante;


    public Comedia(int id, String nombre, Date fecha, int duracion) {
        super(id, nombre, fecha, duracion);
    }
}
