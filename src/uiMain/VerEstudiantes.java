package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerEstudiantes extends OpcionDeMenu{
	private String nombre="VerEstudiantes";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		System.out.println(Archivo.verEstudiantes());
	}

	public String toString() {
		return "Ver estudiantes";
	}
}
