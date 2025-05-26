import java.time.LocalDate;

public class Vehiculo {
    String dominio;
    int añoFabricacion;
    double montoCompra;
    LocalDate fechaFabricacion;

    public Vehiculo(String patente,int añoFabricacion, double montoCompra){
        this.dominio=dominio;
        this.añoFabricacion=añoFabricacion;
        this.montoCompra=montoCompra;
    }

    public String getDominio() {
        return dominio;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public LocalDate obtenerFechaFabricacion(int añoFabricacion){
        LocalDate fechaFabricacion = LocalDate.of(añoFabricacion, 1, 1);
        return fechaFabricacion;
    }

    public LocalDate getFechaFabricacion(){
        return fechaFabricacion;
    }

    @Override
    public String toString() {
        return "\n-- Vehiculo --\n- Dominio: " + dominio + "\n- Año: " + añoFabricacion +
                " - Monto: " + montoCompra;
    }

}
