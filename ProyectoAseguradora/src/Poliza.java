import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Poliza {
    private Cliente cliente;
    private double monto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean estado; //True: vigente; False: no vigente

    // Constructor base para todas las polizas
    public Poliza(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin){
        this.cliente=cliente;
        this.monto=monto;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }

    // Metodo abstracto para calcular monto que las subclases deberán implementar:

    public abstract double calcularCosto(int edad, double monto);


    //Metodos que las subclases heredan:
    public int calcularEdad(Cliente cliente, LocalDate fechaInicio){
        int edad = (int) ChronoUnit.YEARS.between(fechaInicio,cliente.getFechaNacimiento());
        cliente.setEdad(edad);
        return edad;
    }

    public boolean estaVigente(LocalDate fechaInicio, LocalDate fechaFin) {
        if ((int) ChronoUnit.YEARS.between(fechaInicio, fechaFin) > 0) {
            System.out.print("- Esta vigente: SI");
            return true;
        } else {
            System.out.print("- Esta vigente: NO");
        }
        return false;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

}
