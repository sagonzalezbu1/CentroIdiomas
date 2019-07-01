package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerEstudiantes extends OpcionDeMenu{
	public void ejecutar() {
		System.out.println(Archivo.verEstudiantes());
	}

	public String toString() {
		return " Ver estudiantes";
	}
}
