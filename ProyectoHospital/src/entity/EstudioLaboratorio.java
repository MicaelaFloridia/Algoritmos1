package entity;

public class EstudioLaboratorio extends Estudio {
   private int cantidadItems;

    public EstudioLaboratorio(int cantidadItems) {
        super("Laboratorio",
                "Estudio de Laboratorio");
        this.cantidadItems = cantidadItems;
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
