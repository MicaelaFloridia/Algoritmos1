package entity;

public class EstudioRX extends Estudio {
    private ZonaCuerpo zona;

    public EstudioRX(ZonaCuerpo zona) {
        super("Rayos X", String.format("Estudio de imagen RX de %s", zona));
        this.zona = zona;
    }

    public EstudioRX(String zonaComoString) {
        super("Rayos X", String.format("Estudio de imagen RX de %s",
                zonaComoString));
        this.zona = ZonaCuerpo.valueOf(zonaComoString.toUpperCase());
    }

    public ZonaCuerpo getZonaCuerpo() {
        return zona;
    }

    @Override
    public void realizarEstudio(Paciente paciente,Profesional profesional) {
        this.setEstado(true); // Marca el estudio como realizado
        paciente.incrementarEstudiosRealizados(); // Incrementa el contador de estudios
        // del paciente
        System.out.println("Notificando a paciente " + paciente + " sobre " +
                this.toString());
        System.out.println("Notificando a profesional " + profesional + " sobre " +
                this.toString());
    }

}

