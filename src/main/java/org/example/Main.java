package org.example;

import org.example.repositories.AlojamientoRepository;
import org.example.services.alojamiento.InicializadorData;

import static org.example.services.alojamiento.BusquedaAlojamiento.ingresarBusqueda;


public class Main {
    public static void main(String[] args) {

        AlojamientoRepository alojamientoRepository = AlojamientoRepository.getInstance();
        InicializadorData.inicializarData(alojamientoRepository);

//        // mostrar alojamientos por ahora
//        alojamientoRepository.getAlojamientos().forEach(alojamiento -> System.out.println(alojamiento));

        ingresarBusqueda();
    }
}