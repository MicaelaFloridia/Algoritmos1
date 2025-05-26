import java.time.LocalDate;

public class Reserva {
    private Hotel hotel;
    private Cliente cliente;
    private int nroReserva;
    private Habitacion habitacion;
    private int cantidadNoches;
    private LocalDate fechaCheckin;
    private LocalDate fechaCheckout;
    private int cantidadPersonas;
    private double montoTotal;

    public Reserva(Hotel hotel, Cliente cliente, int nroReserva,
                   LocalDate fechaCheckin, LocalDate fechaCheckout,
                   int cantidadPersonas, Habitacion habitacion) {
        this.hotel = hotel;
        this.cliente = cliente;
        this.nroReserva = nroReserva;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckout = fechaCheckout;
        this.cantidadPersonas = cantidadPersonas;
        this.habitacion = habitacion;
        this.cantidadNoches = (int) java.time.temporal.ChronoUnit.DAYS.between(fechaCheckin,
                fechaCheckout);
        this.montoTotal = (hotel.getPrecioNoche()) * cantidadNoches;
    }

    public void setNroReserva(int nroReserva) {
        this.nroReserva = nroReserva;
    }

    public LocalDate getFechaCheckin() {
        return fechaCheckin;
    }

    public LocalDate getFechaCheckout() {
        return fechaCheckout;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }


    @Override
    public String toString() {
        return "\n**Reserva " + nroReserva +
                "\n" + habitacion.toString() +
                "\n- Cliente: " + cliente.getNombreCliente() +
                "\n- Checkin: " + fechaCheckin +
                "\n- Checkout: " + fechaCheckout +
                "\n- Cantidad de noches: " + cantidadNoches +
                "\n- Monto: " + String.format("%.2f", montoTotal);
    }

}