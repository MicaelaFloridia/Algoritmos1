package entity;

import java.util.ArrayList;
import java.util.List;

public class Receta {
    private int nroReceta;
    private Profesional profesional;
    private Paciente paciente;
    private List<Estudio> estudios;
    private boolean procesada;
    private static int contadorRecetas = 0;

    public Receta(Profesional profesional, Paciente paciente, Estudio[] estudios) {
        Receta.contadorRecetas++; // Incrementa el contador estático
        this.nroReceta= Receta.contadorRecetas;
        this.profesional = profesional;
        this.paciente = paciente;
        this.estudios = new ArrayList<>();
        for (Estudio estudio : estudios) {
            this.estudios.add(estudio);
        }
        this.procesada = false; // Inicialmente, la receta está pendiente de procesamiento
    }

    public boolean getEstado(){
        return procesada;
    }

    public int getNroReceta(){
        return nroReceta;
    }

    public List<Estudio> getEstudios(){
        return estudios;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public void procesar() {
        procesada = true;
        for (Estudio est : estudios){
            est.realizarEstudio(paciente, profesional);
        }
    }

    @Override
    public String toString() {
        String resultado = ""; // Inicializamos una cadena vacía
        resultado += "Receta " + nroReceta + ":\n"; // Concatenamos
        resultado += "-  Profesional: " + profesional + "\n";
        resultado += "-  Paciente: " + paciente + "\n";
        resultado += "-  Estado: " + (procesada ? "PROCESADA" : "CARGADA") + "\n";
        resultado += "-  Estudios:\n";

        for (Estudio estudio : estudios) {
            resultado += "    - " + estudio + "\n"; // Concatenamos dentro del bucle
        }
        return resultado; // Devolvemos la cadena final
    }
}
