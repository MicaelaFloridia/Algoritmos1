public class Equipo {
    private String nombre;
    private int cantidadFans;
    private int partidosJugados;
    private int puntosTotales;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;


    public Equipo(String nombre, int cantidadFans) {
        this.nombre = nombre;
        this.cantidadFans = cantidadFans;
        // Inicializar todas las estadísticas a 0
        this.partidosJugados = 0;
        this.puntosTotales = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
    }

    public int getCantidadFans() {
        return cantidadFans;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getDiferenciaGoles() {
        return golesAFavor - golesEnContra;
    }

    // Métodos para actualizar las estadísticas
    public void sumarPartidoJugado() {
        this.partidosJugados++;
    }

    public void sumarPuntos(int puntos) {
        this.puntosTotales += puntos;
    }

    public void sumarPartidoGanado() {
        this.partidosGanados++;
    }

    public void sumarPartidoEmpatado() {
        this.partidosEmpatados++;
    }

    public void sumarPartidoPerdido() {
        this.partidosPerdidos++;
    }

    public void sumarGolesAFavor(int goles) {
        this.golesAFavor += goles;
    }

    public void sumarGolesEnContra(int goles) {
        this.golesEnContra += goles;
    }
}

