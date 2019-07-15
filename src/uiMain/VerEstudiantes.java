package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerEstudiantes extends OpcionDeMenu{
	String nombre="VerEstudiantes";
	public void ejecutar() {
		System.out.println(Archivo.verEstudiantes());
	}

	public String toString() {
		return "Ver estudiantes";
	}
}
