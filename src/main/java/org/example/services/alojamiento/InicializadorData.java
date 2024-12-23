package org.example.services.alojamiento;

import org.example.models.*;
import org.example.repositories.AlojamientoRepository;

import java.util.ArrayList;

public class InicializadorData {
    public static void inicializarData(AlojamientoRepository repositorio) {
        ArrayList<Habitacion> habitacionesAlojamiento1 = new ArrayList<>();
        ArrayList<Habitacion> habitacionesAlojamiento2 = new ArrayList<>();
        ArrayList<Habitacion> habitacionesAlojamiento3 = new ArrayList<>();
        ArrayList<Habitacion> habitacionesAlojamiento4 = new ArrayList<>();
        ArrayList<Habitacion> habitacionesAlojamiento5 = new ArrayList<>();

        DiaDeSolData diaDeSol1 = new DiaDeSolData("nadar", "Incluye Almuerzo y refrigerio");

        habitacionesAlojamiento1.add(new Habitacion("Individual", "Cama individual", 100.0, 5));
        habitacionesAlojamiento1.add(new Habitacion("Doble", "Cama doble", 120.0, 4));
        habitacionesAlojamiento1.add(new Habitacion("Doble plus", "Cama King Size, baño privado", 150.0, 5));
        habitacionesAlojamiento1.add(new Habitacion("Suite", "Cama King Size, baño privado, vistas al mar", 200.0, 3));
        habitacionesAlojamiento1.add(new Habitacion("Presidencial", "Cama King Size, baño privado con Jacuzzi, vistas al mar", 200.50, 3));

        habitacionesAlojamiento2.add(new Habitacion("Mini", "Cama doble, cocina + mini sala + un baño compartidos", 120.0, 6));
        habitacionesAlojamiento2.add(new Habitacion("Loft", "Cama doble, espacio abierto + cocina + un baño + sala + barra-comedor compaprtidos", 150.0, 4));
        habitacionesAlojamiento2.add(new Habitacion("Duplex", "Cama doble, cocina + sala + comedor + un baño compartidos", 170.0, 4));
        habitacionesAlojamiento2.add(new Habitacion("Tripex", "Cama doble, baño privado, cocina + sala + comedor compartidos", 180.25, 4));
        habitacionesAlojamiento2.add(new Habitacion("De lujo", "Cama king, baño privado, sala con chimenea + cocina + comedor + mini bar compartidos", 200.0, 4));

        habitacionesAlojamiento3.add(new Habitacion("Cabaña", "Cama doble, baño privado, cocina + sala + comedor + jardín compartidos", 150.0, 9));
        habitacionesAlojamiento3.add(new Habitacion("Urbana", "Cama King Size, baño privado, cerca a la ciudad, cocina + sala + comedor compartidos", 175.0, 7));
        habitacionesAlojamiento3.add(new Habitacion("Rústica", "Cama King Size, baño privado, cocina + sala + comedor + mini granja compartido", 200.50, 7));
        habitacionesAlojamiento3.add(new Habitacion("Ecológica", "Cama doble, baño privado, cocina + sala + comedor + granja + mini bosque compartidos", 220.0, 7));
        habitacionesAlojamiento3.add(new Habitacion("Hacienda", "Cama doble, baño privado, cocina + sala + comedor + bosque, salón de eventos compartidos", 270.0, 7));

        habitacionesAlojamiento4.add(new Habitacion("Rubí", "Cama individual", 80.0, 9));
        habitacionesAlojamiento4.add(new Habitacion("Esmeralda", "Cama doble", 100.0, 7));
        habitacionesAlojamiento4.add(new Habitacion("Oro", "Cama King Size, baño privado", 150.0, 7));
        habitacionesAlojamiento4.add(new Habitacion("Plata", "Cama King Size, baño privado, sala de estar", 200.0, 7));
        habitacionesAlojamiento4.add(new Habitacion("Diamante", "Cama King Size, baño privado con Jacuzzi, sala de estar", 250.0, 7));

        habitacionesAlojamiento5.add(new Habitacion("Pluton", "Cama individual", 110.0, 5));
        habitacionesAlojamiento5.add(new Habitacion("Venus", "Cama doble", 120.0, 4));
        habitacionesAlojamiento5.add(new Habitacion("Marte", "Cama King Size, baño privado", 150.0, 5));
        habitacionesAlojamiento5.add(new Habitacion("Saturno", "Cama King Size, baño privado, vistas al mar", 200.0, 3));
        habitacionesAlojamiento5.add(new Habitacion("Jupiter", "Cama King Size, baño privado con Jacuzzi, vistas al mar", 200.50, 3));

        Hotel hotel1 = new Hotel("Starlight Hotel", "Cartagena", 5, 2, 5.0, habitacionesAlojamiento1, diaDeSol1, true);
        Apartamento apartamento1 = new Apartamento("Cosmos", "Venecia", 2, 4, 4.0, habitacionesAlojamiento2, 4, "D105");
        Finca finca1 = new Finca("Blue Moon", "Porto", 2, 4, 4.7, habitacionesAlojamiento3, diaDeSol1);
        Hotel hotel2 = new Hotel("Dark Sun Hotel", "Munich", 2, 4, 4.0, habitacionesAlojamiento4, diaDeSol1, true);
        Hotel hotel3 = new Hotel("Andromeda Hotel", "Cartagena", 2, 4, 3.8, habitacionesAlojamiento5, diaDeSol1, false);

        repositorio.addAlojamiento(hotel1);
        repositorio.addAlojamiento(apartamento1);
        repositorio.addAlojamiento(finca1);
        repositorio.addAlojamiento(hotel2);
        repositorio.addAlojamiento(hotel3);
    }
}
