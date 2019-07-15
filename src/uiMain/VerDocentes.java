package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerDocentes extends OpcionDeMenu{
	String nombre="VerDocentes";
	public void ejecutar() {
		System.out.println(Archivo.verDocentes());
	}

	public String toString() {
		return "Ver docentes";
	}
	
}
