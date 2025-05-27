package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PolizaSeguroVehiculo extends Poliza {
    private double costoAnual;
    private Vehiculo vehiculo;
    int antiguedad;

    public PolizaSeguroVehiculo(Cliente cliente,Vehiculo vehiculo, LocalDate fechaInicio,
                                LocalDate fechaFin){
        super(cliente,fechaInicio,fechaFin);
        this.vehiculo=vehiculo;
    }

    public int calcularAntiguedad(Vehiculo vehiculo, LocalDate fechaInicio) {
        LocalDate fechaFabricacionVehiculo = vehiculo.getFechaFabricacion();

        int antiguedadCalculada = (int) ChronoUnit.YEARS.between(fechaFabricacionVehiculo,
                fechaInicio);
        this.antiguedad = antiguedadCalculada; // Almacenamos la antigüedad calculada
        return antiguedadCalculada;
    }

    public double calcularMonto(Vehiculo vehiculo, LocalDate fechaInicio){
        // Primero, calculamos la antigüedad del vehículo
        int antiguedadCalculada = calcularAntiguedad(vehiculo, fechaInicio);
        double montoCalculado=vehiculo.getMontoCompra()-
                (0.05* vehiculo.getMontoCompra()*antiguedadCalculada);
        setMontoAsegurado(montoCalculado);
        return montoCalculado;
    }

    @Override
    public double calcularCosto(int edadClienteAlInicio, double montoAseguradoActual){
        if(edadClienteAlInicio<30){
            costoAnual=montoAseguradoActual*0.2;
        } else {
            costoAnual=montoAseguradoActual*0.1;
        }
        return costoAnual;
    }

    // Getter para el costo anual
    public double getCostoAnual() {
        return costoAnual;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    @Override
    public String toString() {
        return "-- Poliza de Seguro de Vehículo --\n" +
                getCliente() +
                "- Monto asegurado: $" + String.format("%.2f", getMontoAsegurado()) +
                "\n- Costo anual: $" + String.format("%.2f", costoAnual) +
                "\n- Vigencia desde: " + getFechaInicio() +
                "\n- Vigencia hasta: " + getFechaFin() +
                "\n- Está vigente: " + (estaVigente() ? "SI" : "NO") +
                "\n" + vehiculo +
                "\n- Antigüedad del vehículo (al inicio): " + antiguedad + " años";
    }

}
