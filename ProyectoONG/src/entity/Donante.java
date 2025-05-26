package entity;

public class Donante {
    private String nombre;
    private String apellido;
    private int idDonante;

    public Donante(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        this.idDonante=idDonante;
    }

    public String getNombreDonante() {
        return nombre;

    }

    public String getApellidoDonante() {
        return apellido;

    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    @Override
    public String toString() {
        return "(" + idDonante + ") " + apellido + ", " + nombre;
    }
}
