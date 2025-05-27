package entity;

import java.time.LocalDate;

public abstract class Poliza {
    private Cliente cliente;
    private double montoAsegurado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor base para todas las polizas
    public Poliza(Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin){
        this.cliente=cliente;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }

    // Metodo abstracto para calcular monto que las subclases deberán implementar:

    public abstract double calcularCosto(int edad, double montoAsegurado);

    public boolean estaVigente(){
        LocalDate hoy = LocalDate.now();
        // La póliza está vigente si la fecha actual es igual o posterior a la fecha de inicio
        // E igual o anterior a la fecha de fin.
        return (!hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin));
    }

    public int getEdadClienteAlInicioDePoliza(){
        return cliente.obtenerEdadEnFecha(fechaInicio);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    protected void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }


    // Metodo para cambiar el cliente de la póliza
    //  (para transferir, solo para pólizas transferibles)

    protected void setCliente(Cliente nuevoCliente) {
        this.cliente = nuevoCliente;
    }

}
