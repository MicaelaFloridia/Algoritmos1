package entity;

public class Profesional {
    private String nombreProfesional;
    private int matricula;

    public Profesional (int matricula,String nombreProfesional) {
        this.nombreProfesional= nombreProfesional;
        this.matricula= matricula;
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
