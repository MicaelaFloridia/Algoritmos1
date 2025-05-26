import java.time.LocalDate;

public class Partido {
    private LocalDate fecha;
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipoLocal,String equipoVisitante,
                   LocalDate fecha, int golesLocal, int golesVisitante) {
    this.equipoLocal=equipoLocal;
    this.equipoVisitante=equipoVisitante;
    this.fecha=fecha;
    this.golesLocal=golesLocal;
    this.golesVisitante=golesVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", " + equipoLocal + " (" + golesLocal + ") - " +
                equipoVisitante + " (" + golesVisitante + ")\n";
    }

}
