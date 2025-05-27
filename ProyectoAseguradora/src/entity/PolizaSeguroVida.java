package entity;

import java.time.LocalDate;

public class PolizaSeguroVida extends Poliza {
    private double costoAnual;

    public PolizaSeguroVida(Cliente cliente, double montoAsegurado, LocalDate fechaInicio,
                            LocalDate fechaFin){
        super(cliente,fechaInicio,fechaFin);
        setMontoAsegurado(montoAsegurado); // Usamos el setter protegido de Poliza
    }

    public double getCostoAnual() {
        return costoAnual;
    }

    @Override
    public double calcularCosto(int edad, double montoAseguradoActual){
        if(edad<35){
            costoAnual=montoAseguradoActual*0.05;
        } else {
            costoAnual=montoAseguradoActual*0.1;
        }
        return costoAnual;
    }

    @Override
    public String toString() {
        return "-- Poliza de Seguro de Vida --\n" +
                getCliente() + // Obtiene el objeto Cliente y llama a su toString()
                "- Monto asegurado: $" + String.format("%.2f", getMontoAsegurado()) +
                "\n- Costo anual: $" + String.format("%.2f", costoAnual) +
                "\n- Vigencia desde: " + getFechaInicio() +
                "\n- Vigencia hasta: " + getFechaFin() +
                "\n- Está vigente: " + (estaVigente() ? "SI" : "NO");
    }

}
