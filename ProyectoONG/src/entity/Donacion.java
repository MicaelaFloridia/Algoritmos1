package entity;

import java.time.LocalDate;

public class Donacion {
    private Donante donante;
    private LocalDate fecha;
    private float monto;
    private int idDonacion;
    private Estado estado;

    public Donacion(Donante donante, LocalDate fecha, float monto) {
        this.donante = donante;
        this.fecha = fecha;
        this.monto = monto;
        this.idDonacion = idDonacion;
        this.estado = Estado.PENDIENTE;

    }

    public Donante getDonante() {
        return donante;
    }

    public LocalDate getFechaDonacion() {
        return fecha;
    }

    public float getMonto() {
        return monto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }


    public void setCobrada() {
        this.estado = Estado.COBRADA;
    }

    public void setRechazada() {
        this.estado = Estado.RECHAZADA;
    }

    @Override
    public String toString() {
        return "entity.Donacion " + idDonacion + "\n"+
                " - entity.Donante: " + donante+ "\n"+
                " - Fecha: " + fecha +  "\n"+
                " - entity.Estado: " + estado+  "\n"+
                " - Monto: " + String.format("%.1f", monto);
    }
}


