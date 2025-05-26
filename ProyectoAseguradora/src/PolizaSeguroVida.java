import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PolizaSeguroVida extends Poliza {
    private double costoAnual;
    private double monto;

    public PolizaSeguroVida(){
        super(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin)
        this.costoAnual=costoAnual;
        this.monto=monto;
    }

    public int calcularEdad(Cliente cliente, LocalDate fechaInicio){
        int edad = (int) ChronoUnit.YEARS.between(fechaInicio,cliente.getFechaNacimiento());
        cliente.setEdad(edad);
        return edad;
    }

    @Override
    public double calcularCosto(int edad, double monto){
        if(edad<35){
            costoAnual=monto*0.05;
        } else {
            costoAnual=monto*0.1;
        }
        return costoAnual;
    }
}
