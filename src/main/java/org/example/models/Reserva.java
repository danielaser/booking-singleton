package org.example.models;

import java.time.LocalDate;

public class Reserva {

    private Alojamiento alojamiento;
    private ClienteData cliente;
    private String horaLlegadaUsuario;
    private String[] habitacionesSeleccionadas;
    private LocalDate inicioEstadia;
    private LocalDate finEstadia;

    public Reserva(Alojamiento alojamiento, ClienteData cliente, String horaLlegadaUsuario, String[] habitacionesSeleccionadas, LocalDate inicioEstadia, LocalDate finEstadia) {
        this.alojamiento = alojamiento;
        this.cliente = cliente;
        this.horaLlegadaUsuario = horaLlegadaUsuario;
        this.habitacionesSeleccionadas = habitacionesSeleccionadas;
        this.inicioEstadia = inicioEstadia;
        this.finEstadia = finEstadia;
    }

    public Reserva() {
    }

    // getters and setters
    public ClienteData getCliente() {
        return cliente;
    }

    public String getHoraLlegadaUsuario() {
        return horaLlegadaUsuario;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public String[] getHabitacionesSeleccionadas() {
        return habitacionesSeleccionadas;
    }

    public LocalDate getInicioEstadia() {
        return inicioEstadia;
    }

    public LocalDate getFinEstadia() {
        return finEstadia;
    }
}
