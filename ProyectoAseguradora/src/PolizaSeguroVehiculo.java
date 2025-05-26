import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PolizaSeguroVehiculo extends Poliza {
    private double costoAnual;
    private double monto;
    private Vehiculo vehiculo;

    public PolizaSeguroVehiculo(){
        super(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin)
        this.costoAnual=costoAnual;
        this.monto=monto;
    }

    public int calcularAntiguedad(Vehiculo vehiculo,LocalDate fechaInicio){
        int antiguedad = (int) ChronoUnit.YEARS.between(fechaInicio,
                vehiculo.getFechaFabricacion());
        return antiguedad;
    }

    public double calcularMonto(Vehiculo vehiculo,LocalDate fechaInicio){
        monto=vehiculo.getMontoCompra()-(0.05* vehiculo.getMontoCompra()*antiguedad);
        return monto;
    }

    @Override
    public double calcularCosto(int edad, double monto){
        if(edad<30){
            costoAnual=monto*0.2;
        } else {
            costoAnual=monto*0.1;
        }
        return costoAnual;
    }

}
