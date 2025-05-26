import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int edad;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad=edad;
    }

    public String getNombreCliente() {
        return nombre;
    }

    public String getApellidoCliente() {
        return apellido;
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
        return "- Cliente: " + nombre + " " + apellido + " (" + edad + ")";
    }

}