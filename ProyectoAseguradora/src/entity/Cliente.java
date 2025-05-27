package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Cliente {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad=0;
    }

    public int obtenerEdadEnFecha(LocalDate fechaInicio){
        int edadCalculada = (int) ChronoUnit.YEARS.between(fechaNacimiento, fechaInicio);
        // Este metodo NO SETEA la edad del objeto cliente, solo la devuelve.
        // La edad del objeto cliente se seteará con setEdad() cuando sea necesario.
        return edadCalculada;
    }

    public int calcularYSetearEdadActual(){
        LocalDate hoy = LocalDate.now();
        int edadActualCalculada = (int) ChronoUnit.YEARS.between(fechaNacimiento, hoy);
        if (edadActualCalculada < 0) {
            edadActualCalculada = 0;
        }
        this.edad = edadActualCalculada; // <--- Aquí se actualiza el atributo 'edad'
        return this.edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "- Cliente: " + nombre + " " +
                apellido + " (" + edad + ")\n";
    }

}