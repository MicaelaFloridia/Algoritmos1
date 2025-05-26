import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombreHotel;
    private String direccion;
    private double precioNoche;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private int contadorHabitaciones = 1;
    private int contadorReservas=1;
    private Reserva reserva;

    public Hotel(String nombreHotel, String direccion) {
        this.nombreHotel = nombreHotel;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>(); // Inicializa la lista de habitaciones
        this.reservas = new ArrayList<>();
    }

    public void definirPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public void agregarHabitacion(int capacidad) {
        if (capacidad < 1) {
            System.out.println(":\n Error: Ingrese una capacidad mayor a cero.");
            return;
        }
        Habitacion nuevaHabitacion = new Habitacion(capacidad);
        nuevaHabitacion.setNroHabitacion(contadorHabitaciones);
        habitaciones.add(nuevaHabitacion); // Añade la habitacion a la lista del hotel
        System.out.println("\nHabitacion " + nuevaHabitacion.getNroHabitacion() +
                " con capacidad para " + nuevaHabitacion.getCapacidad() +
                " personas cargada exitosamente.");
        contadorHabitaciones++; // Incrementa el contador estático
        }

    public boolean estaDispEstaHabitacion(Habitacion habitacion,LocalDate fechaCheckin,
                                          LocalDate fechaCheckout) {
        boolean estaDisponible = true;
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) &&
    // Lógica de solapamiento de fechas:
    // Se solapa si: (nueva_checkin < existente_checkout) Y (nueva_checkout > existente_checkin)
                    ((fechaCheckin.isBefore(reserva.getFechaCheckout()) &&
                            fechaCheckout.isAfter(reserva.getFechaCheckin())))) {
                return false;
            }
        }
        return estaDisponible;
    }

    public void consultarDisponibilidad(LocalDate fechaCheckin, LocalDate fechaCheckout) {
        System.out.println("\n * Habitaciones disponibles entre " + fechaCheckin + " y " +
                fechaCheckout);
        boolean hayDisponibles = false;
        for (Habitacion hab : habitaciones) {
            boolean estaDisponible = estaDispEstaHabitacion(hab,fechaCheckin,fechaCheckout);
            if (estaDisponible){
                System.out.println(hab);
                hayDisponibles=true;
            }
            if (!hayDisponibles) { // Mensaje si no hay habitaciones disponibles
                System.out.println("No se encontraron habitaciones disponibles" +
                        "para este período.");
            }

            }
        }

    public void reservarHabitacion (Cliente cliente, LocalDate fechaCheckin,
                                           LocalDate fechaCheckout,int cantidadPersonas) {
        //Ordenar de MAYOR a MENOR capacidad:
        List<Habitacion> habitacionesCandidatas = new ArrayList<>(habitaciones);
        habitacionesCandidatas.sort((a, b) ->
                Integer.compare(b.getCapacidad(), a.getCapacidad()));
        Habitacion habitacionElegida = null;

        for (Habitacion habitacion : habitacionesCandidatas) {
            boolean estaDisponible = estaDispEstaHabitacion(habitacion, fechaCheckin, fechaCheckout);
            if (estaDisponible && habitacion.getCapacidad() >= cantidadPersonas) {
                habitacionElegida = habitacion;
                break; // Se encontró una habitación, salir del bucle
            }
        }
        Reserva nuevaReserva = new Reserva(this, cliente, contadorReservas,
                        fechaCheckin, fechaCheckout,cantidadPersonas,habitacionElegida);
                reservas.add(nuevaReserva); // Añade la reserva a la lista de reservas
                contadorReservas++;
                return;

            }



        public void mostrarReservasHotel () {
            if (reservas.size() == 0) {
                System.out.println("\nNo hay habitaciones reservadas.");
                return;
            } else {
                System.out.println("\n*  Reservas del hotel " + nombreHotel);
                for (Reserva r : reservas) {
                    System.out.println(r);
                }

            }
        }

        public double getPrecioNoche () {
            return precioNoche;
        }

    }