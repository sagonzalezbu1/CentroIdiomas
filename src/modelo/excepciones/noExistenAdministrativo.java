package modelo.excepciones;

public class noExistenAdministrativo extends Exception{
	public noExistenAdministrativo() {
		super("No existe administrativo");
	}
}
