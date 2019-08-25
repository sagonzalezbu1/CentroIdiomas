package modelo.excepciones;

public class noExisteAdministrativo extends Exception{
	public noExisteAdministrativo() {
		super("No existe administrativo");
	}
}
