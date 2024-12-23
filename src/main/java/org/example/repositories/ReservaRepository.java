package org.example.repositories;

import org.example.models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {

    private static ReservaRepository instance;
    private List<Reserva> reservas;

    private ReservaRepository() {
        reservas = new ArrayList<>();
    }

    public static ReservaRepository getInstance() {
        if (instance == null) {
            instance = new ReservaRepository();
        }

        return instance;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addBook(Reserva reserva) {
        reservas.add(reserva);
    }
}
