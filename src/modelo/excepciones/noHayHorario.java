package modelo.excepciones;

public class noHayHorario extends Exception {
	public noHayHorario() {
		super("No hay horario");
	}
}
