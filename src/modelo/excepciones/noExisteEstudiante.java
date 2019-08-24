package modelo.excepciones;

public class noExisteEstudiante extends Exception {
	public noExisteEstudiante(){
		super("No existe estudiante");
	}
}
