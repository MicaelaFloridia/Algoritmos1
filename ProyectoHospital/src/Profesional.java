public class Profesional {
    private String nombreProfesional;
    private int matricula;

    public Profesional (String nombreProfesional, int matricula) {
        this.nombreProfesional= nombreProfesional;
        this.matricula= matricula;
    }

    public void recetar(Estudio[] estudio,Paciente paciente) {

    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return nombreProfesional + " [" + matricula + "]";
    }



}
