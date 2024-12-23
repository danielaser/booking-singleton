package org.example.repositories;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRepository {

    private static AlojamientoRepository instance;
    private List<Alojamiento> alojamientos;

    private AlojamientoRepository() {
        alojamientos = new ArrayList<>();
    }

    public static AlojamientoRepository getInstance() {
        if (instance == null) {
            synchronized (AlojamientoRepository.class) {
                if (instance == null) {
                    instance = new AlojamientoRepository();
                }
            }
        }
        return instance;
    }

    public List<Alojamiento> getAlojamientos() {
        return alojamientos;
    }

    public void addAlojamiento(Alojamiento alojamiento) {
        alojamientos.add(alojamiento);
    }
}
