public class Habitacion {
    private int nroHabitacion;
    private int capacidad;

    public Habitacion(int capacidad){
        this.capacidad = capacidad;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion= nroHabitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "- Habitacion Base " + nroHabitacion + " , capacidad = " + capacidad
        + " pax.";
    }

}
