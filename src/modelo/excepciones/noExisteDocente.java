package modelo.excepciones;

public class noExisteDocente extends Exception {
	public noExisteDocente() {
		super("No existen docente");
	}
}
