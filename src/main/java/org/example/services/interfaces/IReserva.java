package org.example.services.interfaces;

import org.example.models.ReservaData;

public interface IReserva {

    void crearReserva(ReservaData reserva);

    void actualizarReserva(ReservaData reserva);

    void eliminarReserva(ReservaData reserva);

    String mostrarReserva(ReservaData reserva);
}

