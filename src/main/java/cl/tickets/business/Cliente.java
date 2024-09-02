package cl.tickets.business;

import java.util.List;

public class Cliente extends Usuario{

    private List<String> preferencias;
    private List<Reserva> reservas;
    private List<Venta> ventas;
}
