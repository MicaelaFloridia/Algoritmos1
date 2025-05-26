package entity;

public abstract class Estudio {
    private String nombreEstudio;
    private String descripcion;
    private boolean estado; //true: REALIZADO; false: PENDIENTE

    // Constructor base para todos los estudios
    public Estudio(String nombreEstudio, String descripcion) {
        this.nombreEstudio = nombreEstudio;
        this.descripcion = descripcion;
        this.estado = false; // Por defecto, un estudio está pendiente al ser creado
    }

    public abstract void realizarEstudio(Paciente paciente, Profesional profesional);

    public void setEstado(boolean estado) {
    this.estado=estado;
    }


    @Override
    public String toString() {
        return nombreEstudio + ": " + descripcion + " (" + (estado ? "REALIZADO" :
                "PENDIENTE") + ")";
    }

    }
