package entity;

import java.time.LocalDate;

public class Vehiculo {
    String dominio;
    int añoFabricacion;
    double montoCompra;
    LocalDate fechaFabricacion;

    public Vehiculo(String dominio,int añoFabricacion, double montoCompra){
        this.dominio=dominio;
        this.añoFabricacion=añoFabricacion;
        this.montoCompra=montoCompra;
        this.fechaFabricacion = LocalDate.of(añoFabricacion, 1, 1);
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    // Este getter ahora devolverá el LocalDate correctamente inicializado
    public LocalDate getFechaFabricacion(){
        return fechaFabricacion;
    }

    @Override
    public String toString() {
        return "-- Vehiculo --\n" +
                "- Dominio: " + dominio +
                "\n- Año: " + añoFabricacion +
                "\n- Monto de Compra: $" + String.format("%.2f", montoCompra);
    }

}
