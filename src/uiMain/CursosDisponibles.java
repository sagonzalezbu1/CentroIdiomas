package uiMain;
import gestorAplicacion.Centro.Archivo;

public class CursosDisponibles extends OpcionDeMenu {
	String nombre="CursosDisponibles";
	public void ejecutar() {
		System.out.println(Archivo.verCursos());
	}

	public String toString() {
		return "Ver cursos disponibles";
	}
}
