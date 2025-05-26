public class EstudioRX extends Estudio{
    private String zona;

    public EstudioRX(String zona) {
        super("RX", "Estudio de imagen RX de la siguiente zona: "
                + zona); // Llama al constructor de la clase padre
        this.zona = zona;
    }

    @Override
    public void realizarEstudio(Profesional profesional, Paciente paciente) {
        this.setEstado(true); // Marca el estudio como realizado
        paciente.incrementarEstudiosRealizados(); // Incrementa el contador de
        // estudios del paciente
        System.out.println("Notificando a paciente " + paciente +
                " sobre " + this.toString());
        System.out.println("Notificando a profesional " + profesional +
                " sobre " + this.toString());
    }
}

