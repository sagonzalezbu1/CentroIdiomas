package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerEstudiantes extends OpcionDeMenu{
	public void ejecutar() {
		Archivo.verEstudiantes();
	}

	public String toString() {
		return " Ver estudiantes";
	}
}
