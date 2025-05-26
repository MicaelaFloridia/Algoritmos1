package controller;

import entity.Donacion;
import entity.Donante;
import entity.Estado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ONG {
    private String nombre;
    private List<Donante> donantes;
    private List<Donacion> donaciones;
    private int contadorDonaciones = 1;
    private int contadorDonantes = 1;

    public ONG(String nombre) {
        this.nombre = nombre;
        this.donantes = new ArrayList<>();
        this.donaciones = new ArrayList<>();
    }

    public Donante registrarDonante(String nombre, String apellido) {
        for (Donante donante : donantes) {
            if (donante.getNombreDonante().equals(nombre) &&
                    donante.getApellidoDonante().equals(apellido)) {
                System.out.println("El donante " + nombre + " " + apellido + "ya se encuentra" +
                        " registrado.");
                return donante; // Retorna el donante que ya existía
            }
            break;
        }

        Donante nuevoDonante = new Donante(nombre, apellido);
        donantes.add(nuevoDonante);
        nuevoDonante.setIdDonante(contadorDonantes);
        contadorDonantes++;
        System.out.println("entity.Donante " + nombre + " " + apellido + " registrado " +
                "correctamente.");
        return nuevoDonante; // Retorna el donante recién creado
    }

    public Donacion cargarDonacion(Donante donante, LocalDate fecha, float monto) {

        Donacion nuevaDonacion = new Donacion(donante, fecha, monto);
        donaciones.add(nuevaDonacion);
        nuevaDonacion.setIdDonacion(contadorDonaciones);
        contadorDonaciones++;
        return nuevaDonacion;
    }

    public void mostrarDonantes() {
        System.out.println("\n Listado de donantes de " + nombre);
        for (Donante donante : donantes) {
            System.out.println(donante);
        }
    }

    public void mostrarDonaciones() {
        System.out.println("\nListado de donaciones de " + nombre);
        //Ordenar donaciones por fecha:
        List<Donacion> donacionesOrdenadas = new ArrayList<>(donaciones);
        donacionesOrdenadas.sort((a, b) ->
                a.getFechaDonacion().compareTo(b.getFechaDonacion()));
        for (Donacion donacion : donacionesOrdenadas) {
            System.out.println(donacion);
        }
    }

    public void mostrarResultadoFecha(LocalDate fecha) {

        int donacionesCobradas = 0;
        int donacionesRechazadas = 0;
        int donacionesPendientes = 0;
        float montoTotal=0;
        float montoMaximo = 0;
        float montoMinimo = Float.MAX_VALUE;

        System.out.println("\nentity.Estado de Resultado de Codigo Verde al " + fecha);
        for (Donacion donacion : donaciones) {
            if (donacion.getFechaDonacion().compareTo(fecha) <= 0) {
                if (donacion.getEstado().equals(Estado.COBRADA)) {
                    donacionesCobradas++;
                    montoTotal += donacion.getMonto();
                    if (donacion.getMonto()<montoMinimo){
                        montoMinimo = donacion.getMonto();
                    }

                    if (donacion.getMonto()>montoMaximo){
                        montoMaximo = donacion.getMonto();
                    }

                } else if (donacion.getEstado().equals(Estado.RECHAZADA)) {
                    donacionesRechazadas++;
                } else {
                    donacionesPendientes++;
                }
            }

        }
        double montoMedio = montoTotal/donacionesCobradas;
        System.out.println("- Cobradas: "+ donacionesCobradas +
                "\n- Rechazadas: "+ donacionesRechazadas +
                "\n- Pendientes: "+ donacionesPendientes +
                "\n- Monto Total: $ "+ montoTotal +
                "\n- Monto máximo: $ "+ montoMaximo +
                "\n- Monto mímino: $ "+ montoMinimo +
                "\n- Monto medio: $ "+ montoMedio);
    }
}
