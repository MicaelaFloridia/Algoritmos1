package controller;

import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aseguradora {
    private List<Poliza> polizas;

    public Aseguradora() {
        this.polizas = new ArrayList<>();
    }

    public Poliza asegurarVehiculo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio,
                                 LocalDate fechaFin) {
        PolizaSeguroVehiculo nuevaPoliza = new PolizaSeguroVehiculo(cliente, vehiculo,
                fechaInicio,fechaFin);
        int edadClienteAlInicio = nuevaPoliza.getEdadClienteAlInicioDePoliza();
        // Aquí se calcula y se setea el montoAsegurado
        nuevaPoliza.calcularMonto(vehiculo, fechaInicio);
        nuevaPoliza.calcularCosto(edadClienteAlInicio, nuevaPoliza.getMontoAsegurado());
        polizas.add(nuevaPoliza);
        return nuevaPoliza;
    }

    public Poliza asegurarVida(Cliente cliente, double montoAsegurado, LocalDate fechaInicio,
                                              LocalDate fechaFin) {
        PolizaSeguroVida nuevaPoliza = new PolizaSeguroVida(cliente, montoAsegurado, fechaInicio,
                fechaFin);
        int edadClienteAlInicio = nuevaPoliza.getEdadClienteAlInicioDePoliza();
        nuevaPoliza.calcularCosto(edadClienteAlInicio, nuevaPoliza.getMontoAsegurado());
        polizas.add(nuevaPoliza);
        return nuevaPoliza;
    }

    public void mostrarPolizas() {
        System.out.print("--- Polizas vigentes ---\n");
        boolean algunaVigente = false;
        for (Poliza poliza : polizas) {
            // Antes de imprimir, actualizamos la edad del cliente a la edad ACTUAL del sistema
            poliza.getCliente().calcularYSetearEdadActual();
            if (poliza.estaVigente()) {
                System.out.println(poliza);
                algunaVigente = true;
            }
        }
            if (!algunaVigente) {
                System.out.println("No hay pólizas vigentes.");
                System.out.println();
            }

        System.out.print("--- Polizas vencidas ---\n");
        boolean algunaVencida = false;
        for (Poliza poliza : polizas) {
            poliza.getCliente().calcularYSetearEdadActual();
            if (!poliza.estaVigente()) {
                System.out.println(poliza);
                algunaVencida=true;
            }
        }
        if (!algunaVencida) {
            System.out.println("No hay pólizas vencidas.");
            System.out.println();
        }
    }

//        public void transferirPoliza (Poliza poliza, Cliente cliente){
//
//
//        }
}
