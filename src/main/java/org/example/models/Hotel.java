package org.example.models;

import org.example.models.interfaces.IDiaDeSol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel extends Alojamiento implements IDiaDeSol {
    private DiaDeSolData diaDeSol;
    private Boolean servicioHabitacion;

    public Hotel(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Integer maxNinos, Double calificacion, ArrayList<Habitacion> habitacion, DiaDeSolData diaDeSol, Boolean servicioHabitacion) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, maxNinos, calificacion, habitacion);
        this.diaDeSol = diaDeSol;
        this.servicioHabitacion = servicioHabitacion;
    }

    public Hotel() {
    }

    @Override
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion()
        );
        mostrarInfoDiaDeSol();
        if(isServicioHabitacion()){
            System.out.println("Cuenta con servicio a la habitacion totalmente gratis!!!");
        }
        double precioTotal = calcularPrecioTotal(inicioEstadia, finEstadia, habitacionesSolicitadas);
        System.out.println("El precio base total de la estadía es: $" + precioTotal);
    }

    //sobrecarga
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino()
        );
        System.out.println("Fecha de inicio de estadia: " + inicioEstadia);
        System.out.println("Fecha de fin de estadia: " + finEstadia);
    }

    @Override
    public void mostrarHabitacionesDisponibles() {
        super.mostrarHabitacionesDisponibles();
    }

    @Override
    public Boolean tenerDiaDeSol() {
        return diaDeSol != null;
    }

    @Override
    public String mostrarInfoDiaDeSol() {
        StringBuilder infoActividadesYExtras = new StringBuilder();
        System.out.println("Actividades disponibles:");
        for (String actividad : diaDeSol.getActividades().split(",")) { // Dividimos por comas
            System.out.println("- " + actividad.trim());
        }
        System.out.println("Extras disponibles:");
        for (String extra : diaDeSol.getExtras().split(",")) { // Dividimos por comas
            System.out.println("- " + extra.trim());
        }
        return infoActividadesYExtras.toString();
    }

    // getters and setters
    public Boolean isServicioHabitacion() {
        return servicioHabitacion;
    }
}
