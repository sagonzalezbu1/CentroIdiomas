package uiMain;
import gestorAplicacion.Centro.Archivo;

public class CursosDisponibles extends OpcionDeMenu {
	private String nombre="VerCursos";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Muestra por pantalla los cursos con su informaci�n (salida del toString)
		System.out.println(Archivo.verCursos());
	}

	public String toString() {
		return "Ver cursos";
	}
}