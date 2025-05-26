public abstract class Estudio {
    String nombreEstudio;
    String descripcion;
    boolean estado; //true: REALIZADO; false: PENDIENTE

    // Constructor base para todos los estudios
    public Estudio(String nombreEstudio, String descripcion) {
        this.nombreEstudio = nombreEstudio;
        this.descripcion = descripcion;
        this.estado = false; // Por defecto, un estudio está pendiente al ser creado
    }

    // Metodo para marcar el estudio como realizado
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Metodo getter para el estado
    public boolean isRealizado() {
        return estado;
    }

    // Metodo getter para la descripción
    public String getDescripcion() {
        return descripcion;
    }

    // Metodo abstracto que las subclases deberán implementar
    // Representa la acción de "realizar" el estudio y notificar

    public abstract void realizarEstudio(Profesional profesional, Paciente paciente);

    @Override
    public String toString() {
        return nombreEstudio + ": " + descripcion + " (" + (estado ? "REALIZADO" :
                "PENDIENTE") + ")";
    }
}
