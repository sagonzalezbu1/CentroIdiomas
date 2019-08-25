package modelo.excepciones;

public class noExisteUsuario extends Exception {
	public noExisteUsuario() {
		super("No existe usuario");
	}
}
