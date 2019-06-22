package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerDocentes extends OpcionDeMenu{
	public void ejecutar() {
		Archivo.verDocentes();
	}

	public String toString() {
		return " Ver docentes";
	}
	
}
