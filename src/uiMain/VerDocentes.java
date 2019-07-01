package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerDocentes extends OpcionDeMenu{
	public void ejecutar() {
		System.out.println(Archivo.verDocentes());
	}

	public String toString() {
		return " Ver docentes";
	}
	
}
