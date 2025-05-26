import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Aseguradora {
    private List<Poliza> polizas;


    public Aseguradora(){
        this.polizas=new ArrayList<>();
    }

    public void asegurarVehiculo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio,
                            LocalDate fechaFin){
    Poliza nuevaPoliza =new Poliza(cliente, vehiculo,fechaInicio,fechaFin);
    }

    public void asegurarVida(Cliente cliente, double monto, LocalDate fechaInicio,
                                 LocalDate fechaFin){
    }

    public void mostrarPolizas(){

    }

    public void transferirPoliza(Poliza poliza, Cliente cliente){

    }
}
