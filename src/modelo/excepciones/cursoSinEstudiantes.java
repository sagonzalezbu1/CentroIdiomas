package modelo.excepciones;

public class cursoSinEstudiantes extends Exception{
	public cursoSinEstudiantes() {
		super("No hay estudiantes en el curso");
	}

}
