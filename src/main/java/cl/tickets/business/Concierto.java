package cl.tickets.business;

import java.util.Date;

public class Concierto extends Evento{

    private String director;

    public Concierto(int id, String nombre, Date fecha, int duracion) {
        super(id, nombre, fecha, duracion);
    }
}

