package uiMain;
import gestorAplicacion.Centro.Archivo;

public class CursosDisponibles extends OpcionDeMenu {
	private String nombre="CursosDisponibles";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		System.out.println(Archivo.verCursos());
	}

	public String toString() {
		return "Ver cursos disponibles";
	}
}
