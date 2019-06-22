package uiMain;
import gestorAplicacion.Centro.Archivo;

public class CursosDisponibles extends OpcionDeMenu {
	public void ejecutar() {
		Archivo.verCursos();
	}

	public String toString() {
		return "Ver cursos disponibles";
	}
}
