package cl.tickets.business;

import java.util.Date;
import java.util.List;

public class Teatro extends Evento{

    private String director;
    private List<String> actores;


    public Teatro(int id, String nombre, Date fecha, int duracion, String director, List<String> actores){
        super(id, nombre, fecha, duracion);
        this.director = director;
        this.actores = actores;

    }

    public void ingresarActores(String nombre){
        actores.add(nombre);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


}
