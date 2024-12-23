package org.example.services.alojamiento;

import org.example.models.Alojamiento;
import org.example.models.Finca;
import org.example.models.Habitacion;
import org.example.models.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BuscarAlojamiento {

    public static boolean buscarAlojamiento(ArrayList<Alojamiento> alojamientos, Map<String, Object> params) {
        boolean alojamientoEncontrado = false;
        String ciudad = (String) params.get("ciudad");
        String tipo = (String) params.get("tipo");
        LocalDate inicioEstadia = (LocalDate) params.get("inicioEstadia");
        LocalDate finEstadia = (LocalDate) params.get("finEstadia");
        int adultos = (Integer) params.get("adultos");
        int ninos = (Integer) params.get("ninos");
        int habitaciones = (Integer) params.get("habitaciones");

        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();
        if (diferenciaEnDias <= 0) {System.out.println("Debe alojarse como minimo un dia"); return false; }

        for (int i = 0; i < alojamientos.size(); i++) {
            Alojamiento alojamiento = alojamientos.get(i);
            int totalHabitacionesDisponibles = 0;
            ArrayList<Habitacion> habitacionesDispo = alojamiento.getHabitacion();
            for (int j = 0; j < habitacionesDispo.size(); j++) {
                Habitacion habitacion = habitacionesDispo.get(j);
                totalHabitacionesDisponibles += habitacion.getHabitacionesDisponibles();
            }
            boolean diaDeSol = false;
            if (alojamiento instanceof Hotel) {
                Hotel diaDeSolHotel = (Hotel) alojamiento;
                diaDeSol = diaDeSolHotel.tenerDiaDeSol();
            } else if (alojamiento instanceof Finca) {
                Finca diaDeSolFinca = (Finca) alojamiento;
                diaDeSol = diaDeSolFinca.tenerDiaDeSol();
            }
            if (((tipo.equalsIgnoreCase("Dia de Sol") && diaDeSol) || alojamiento.getClass().getSimpleName().equalsIgnoreCase(tipo)) &&
                    alojamiento.getCiudadDestino().equalsIgnoreCase(ciudad) && alojamiento.getMaxAdultos() >= adultos &&
                    alojamiento.getMaxNinos() >= ninos && totalHabitacionesDisponibles >= habitaciones) {
                alojamientoEncontrado = true;
                alojamiento.mostrarInfo(inicioEstadia, finEstadia, habitaciones, adultos, ninos);
                System.out.println("---------------------------------");
            }
        }
        return alojamientoEncontrado;
    }

    public static Alojamiento elegirAlojamiento(ArrayList<Alojamiento> alojamientos, boolean alojamientoEncontrado) {
        if (alojamientoEncontrado) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione el alojamiento que desea (ingrese el nombre del alojamiento):");
            String hotelSeleccionadoPorUsuario = scanner.nextLine();
            return buscarAlojamientoPorNombre(alojamientos, hotelSeleccionadoPorUsuario);
        } else {
            System.out.println("No se encontraron alojamientos que coincidan con su busqueda. Intente nuevamente");
            return null;
        }
    }

    public static Alojamiento buscarAlojamientoPorNombre(ArrayList<Alojamiento> alojamientos, String nombreAlojamiento){
        for (int i = 0; i < alojamientos.size(); i++) {
            if (alojamientos.get(i).getNombreAlojamiento().equalsIgnoreCase(nombreAlojamiento)) {
                return alojamientos.get(i); //objeto alojamiento
            }
        }
        return null;
    }
}
