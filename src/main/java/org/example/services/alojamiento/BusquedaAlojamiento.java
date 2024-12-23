package org.example.services.alojamiento;

import org.example.models.Alojamiento;
import org.example.models.ClienteData;
import org.example.models.ReservaData;
import org.example.repositories.AlojamientoRepository;
import org.example.services.alojamiento.FiltroAlojamiento;
import org.example.services.habitacion.FiltroHabitacion;
import org.example.services.reserva.ReservaImplementation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BusquedaAlojamiento {
    static boolean continuarBuscandoAlojamiento = true;
    static ReservaImplementation reservaService = new ReservaImplementation();

    // Crear reserva
    static ReservaData reserva = new ReservaData();

    public static void ingresarBusqueda() {
        System.out.println("¡Bienvenido a Starlight Booking!");
        System.out.println("--- * --- * --- * --- * --- * ---");
        Scanner scanner = new Scanner(System.in);

        do {
            Map<String, Object> params = new HashMap<>();

            System.out.println("Ingrese la ciudad destino:");
            params.put("ciudad", scanner.nextLine());

            System.out.println("Ingrese el tipo de alojamiento que desea (Ejemplo: Hotel, Apartamento, Finca, Dia de Sol):");
            params.put("tipo", scanner.nextLine());

            System.out.println("Ingrese la fecha de inicio de la estadia (en formato AAAA-MM-DD):");
            String fechaInicioString = scanner.nextLine();
            params.put("inicioEstadia", LocalDate.parse(fechaInicioString));

            System.out.println("Ingrese la fecha de fin de la estadia (en formato AAAA-MM-DD):");
            String fechaFinString = scanner.nextLine();
            params.put("finEstadia", LocalDate.parse(fechaFinString));

            System.out.println("Ingrese la cantidad de adultos que se van a hospedar:");
            params.put("adultos", scanner.nextInt());

            System.out.println("Ingrese la cantidad de niños que se van a hospedar:");
            params.put("ninos", scanner.nextInt());

            System.out.println("Ingrese la cantidad de habitaciones que desea:");
            params.put("habitaciones", scanner.nextInt());
            scanner.nextLine();

            AlojamientoRepository alojamientoRepository = AlojamientoRepository.getInstance();
            List<Alojamiento> alojamientos = alojamientoRepository.getAlojamientos();

            boolean alojamientoDisponible = FiltroAlojamiento.buscarAlojamiento(alojamientos, params);
            Alojamiento alojamientoElegido = FiltroAlojamiento.elegirAlojamiento(alojamientos, alojamientoDisponible);
            if (alojamientoElegido != null) {
                FiltroHabitacion.verificarCantidadHabitaciones(alojamientoElegido, (Integer) params.get("habitaciones"));
                String[] habitacionesElegidas = FiltroHabitacion.seleccionarHabitaciones(alojamientoElegido, (Integer) params.get("habitaciones"));
                ClienteData cliente = pedirDatosCliente();
                System.out.println("Ingrese la hora de llegada (HH:mm):");
                String horaLlegadaUsuario = scanner.nextLine();
                ReservaData reservaData = new ReservaData(alojamientoElegido, cliente, horaLlegadaUsuario, habitacionesElegidas, (LocalDate) params.get("inicioEstadia"), (LocalDate) params.get("finEstadia"));
                reservaService.crearReserva(reserva);

                menuBooking(reservaData);
            }
        } while (continuarBuscandoAlojamiento);
        scanner.close();
    }

    public static ClienteData pedirDatosCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese su apellido:");
        String apellidoUsuario = scanner.nextLine();

        System.out.println("Ingrese su correo:");
        String correoUsuario = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento con el formatio AAAA-MM-DD:");
        String nacimientoUsuario = scanner.nextLine();

        System.out.println("Ingrese su nacionalidad:");
        String nacionalidadUsuario = scanner.nextLine();

        System.out.println("Ingrese su teléfono:");
        String telefonoUsuario = scanner.nextLine();

        ClienteData cliente = new ClienteData(nombreUsuario, apellidoUsuario, correoUsuario, nacionalidadUsuario, telefonoUsuario, nacimientoUsuario);
        return cliente;
    }

    public static void menuBooking(ReservaData reservaData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elija una de las siguientes opciones: \n1. Crear una nueva reservar" +
                "\n2. Actualizar habitaciones en la reserva \n3. Actualizar alojamiento en la reserva \n4. salir de Starlight Booking");
        String respuestaActualizar = scanner.nextLine();

        if (respuestaActualizar.equalsIgnoreCase("1")) {
            continuarBuscandoAlojamiento = true;
        } else if (respuestaActualizar.equalsIgnoreCase("2")) {
            System.out.println("Estas seguro que quieres actualizar la reserva?");
            reservaData.getAlojamiento().mostrarInfo(reservaData.getInicioEstadia(), reservaData.getFinEstadia());
            reservaService.actualizarReserva(reserva);
            menuBooking(reservaData);
        } else if (respuestaActualizar.equalsIgnoreCase("3")) {
            reservaService.eliminarReserva(reserva);
            continuarBuscandoAlojamiento = true;
        } else {
            System.out.println("¡Gracias por reservar con Starlight Booking!");
            continuarBuscandoAlojamiento = false;
        }
    }

}
