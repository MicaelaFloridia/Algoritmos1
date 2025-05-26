package entity;

public class Paciente {
    private String nombrePaciente;
    private int dni;
    private int estudiosRealizadosCount;

    public Paciente (int dni, String nombrePaciente) {
        this.nombrePaciente= nombrePaciente;
        this.dni= dni;
        this.estudiosRealizadosCount = 0;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public int getDni() {
        return dni;
    }

    // Metodo para incrementar el contador de estudios realizados
    public void incrementarEstudiosRealizados() {
        this.estudiosRealizadosCount++;
    }

    // Metodo getter para obtener el número de estudios realizados
    public int getEstudiosRealizadosCount() {
        return estudiosRealizadosCount;
    }

    @Override
    public String toString() {
        return nombrePaciente + " [" + dni + "]";
    }
}
