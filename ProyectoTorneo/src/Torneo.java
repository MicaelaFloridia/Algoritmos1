import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;


    public Torneo (){
    this.equipos=new ArrayList<>();
    this.partidos=new ArrayList<>();
    }

    public void cargarEquipo(String nombre, int cantidadFans){
        Equipo nuevoEquipo = new Equipo(nombre,cantidadFans);
        equipos.add(nuevoEquipo);
    }

    public void cargarPartido(String nombreEquipoLocal,String nombreEquipoVisitante,
                              LocalDate fecha, int golesLocal, int golesVisitante){

        Equipo equipoLocal = null;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipoLocal)) {
                equipoLocal = equipo;
                break;
            }
        }

        Equipo equipoVisitante = null;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipoVisitante)) {
                equipoVisitante = equipo;
                break;
            }
        }

        //Verificar si los equipos fueron encontrados antes de usarlos
        if (equipoLocal == null) {
            System.out.println("Error: El equipo local '" + nombreEquipoLocal +
                    "' no fue encontrado. Partido no cargado.");
            return;
        }
        if (equipoVisitante == null) {
            System.out.println("Error: El equipo visitante '" + nombreEquipoVisitante +
                    "' no fue encontrado. Partido no cargado.");
            return;
        }

        Partido nuevoPartido = new Partido(nombreEquipoLocal,nombreEquipoVisitante,fecha,
                golesLocal,golesVisitante);
        partidos.add(nuevoPartido);


        //Lógica para actualizar las estadísticas de los equipos

        if (equipoLocal == null || equipoVisitante == null) {
            System.err.println("Error: Uno de los equipos no fue encontrado. Partido no cargado correctamente.");
            return; // Salir si no se encuentran los equipos
        }

        // Actualizar partidos jugados y goles para ambos equipos
        equipoLocal.sumarPartidoJugado();
        equipoLocal.sumarGolesAFavor(golesLocal);
        equipoLocal.sumarGolesEnContra(golesVisitante);

        equipoVisitante.sumarPartidoJugado();
        equipoVisitante.sumarGolesAFavor(golesVisitante);
        equipoVisitante.sumarGolesEnContra(golesLocal);

        // Lógica de puntos y victorias/empates/derrotas
        if (golesLocal > golesVisitante) {
            // Gana el local
            equipoLocal.sumarPuntos(3); // 3 puntos por victoria
            equipoLocal.sumarPartidoGanado();
            equipoVisitante.sumarPartidoPerdido();
        } else if (golesVisitante > golesLocal) {
            // Gana el visitante
            equipoVisitante.sumarPuntos(3); // 3 puntos por victoria
            equipoVisitante.sumarPartidoGanado();
            equipoLocal.sumarPartidoPerdido();
        } else {
            // Empate
            equipoLocal.sumarPuntos(1); // 1 punto por empate
            equipoVisitante.sumarPuntos(1); // 1 punto por empate
            equipoLocal.sumarPartidoEmpatado();
            equipoVisitante.sumarPartidoEmpatado();
        }
    }

    public void  mostrarPartidosFecha(LocalDate fecha){
        System.out.print("Mostrar partidos de la fecha: " + fecha + "\n");
        for (Partido partido :partidos) {
            if(partido.getFecha().equals(fecha)){
                System.out.print(partido);
            }
        }
    }

    public void mostrarTabla(){
        System.out.print("\nEquipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG\n");

        //Ordenar de MAYOR a MENOR puntaje:
        List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
        equiposOrdenados.sort((a, b) -> {
            int comparacionPuntos = Integer.compare(b.getPuntosTotales(), a.getPuntosTotales());
            if (comparacionPuntos == 0) {
                // Si los puntos son iguales, ordenar por diferencia de goles (mayor a menor)
                return Integer.compare(b.getDiferenciaGoles(), a.getDiferenciaGoles());
            }
            return comparacionPuntos;
        });

        for (Equipo equipo :equiposOrdenados) {
            System.out.println(equipo.getNombre() + " | " + equipo.getPartidosJugados() + " | "
                    +equipo.getPuntosTotales() + " | "+ equipo.getPartidosGanados() + " | " +
                    equipo.getPartidosEmpatados() + " | " + equipo.getPartidosPerdidos() + " | " +
                    equipo.getGolesAFavor() + " | " +  equipo.getGolesEnContra() + " | " +
                    equipo.getDiferenciaGoles() + " |");
        }
    }
    }