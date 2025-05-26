package controller;

import entity.Estudio;
import entity.Paciente;
import entity.Profesional;
import entity.Receta;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Hospital {
    private String nombreHospital;
    Map<Integer, Profesional> profesionales;
    Map<Integer, Paciente> pacientes;
    List<Receta> recetas;

    public Hospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
        this.profesionales = new HashMap<>();
        this.pacientes = new HashMap<>();
        this.recetas = new ArrayList<>();
    }

    public Profesional registrarProfesional(String nombreProfesional, int matricula) {
        if (profesionales.containsKey(matricula)) {
            throw new RuntimeException("No se puede crear un profesional con" +
                    "una matricula repetida.");
        }
        Profesional nuevoProfesional = new Profesional(matricula, nombreProfesional);
        profesionales.put(matricula, nuevoProfesional);
        return nuevoProfesional;
    }

    public Paciente registrarPaciente(String nombrePaciente, int dni) {
        if (pacientes.containsKey(dni)) {
            throw new RuntimeException("No se puede crear un paciente con un dni repetido.");
        }
        Paciente nuevoPaciente = new Paciente(dni, nombrePaciente);
        pacientes.put(dni, nuevoPaciente);
        return nuevoPaciente;
    }

    public Receta cargarReceta(Profesional profesional, Paciente paciente
            , Estudio[] estudios) {
        // Chequeo si existe el profesional
        if (!profesionales.containsKey(profesional.getMatricula())) {
            throw new RuntimeException("Profesional no registrado.");
        }
        //Chequeo si existe el paciente
        if (!pacientes.containsKey(paciente.getDni())) {
            throw new RuntimeException("Paciente no registrado.");
        }
        // agregar receta a la colección de recetas
        Receta nuevaReceta = new Receta(profesional, paciente, estudios);
        recetas.add(nuevaReceta);
        return nuevaReceta;
    }

    public void procesar(Receta receta) {
        for (Receta rec : recetas) {
            if (rec.getNroReceta() == receta.getNroReceta()) {
                // se puede validar que la receta no este procesada
                rec.procesar();
            }
        }
    }

    public void mostrarRecetas() {
        System.out.println("\nRecetas de " + nombreHospital);
        for (Receta receta : recetas) {
            System.out.println(receta);
        }
    }

    public void mostrarRecetasProcesadas() {
        System.out.println("\nRecetas procesadas de " + nombreHospital);
        for (Receta receta : recetas) {
            if (receta.getEstado() == true) {
                System.out.println(receta);
            }
        }
    }

    public void mostrarPacientesConEstudios(int minimoEstudiosRealizados) {
        System.out.println("\nPacientes con al menos " + minimoEstudiosRealizados +
                " estudios realizados en " + nombreHospital);
        for (Paciente paciente : pacientes.values()) {
            if (paciente.getEstudiosRealizadosCount() >= minimoEstudiosRealizados) {
                        System.out.println(paciente);
                    }
                }
    }
}