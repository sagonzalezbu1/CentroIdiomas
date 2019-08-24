package modelo.excepciones;

public class noHayCursos extends Exception{
	public noHayCursos() {
		super("No hay cursos");
	}
}
