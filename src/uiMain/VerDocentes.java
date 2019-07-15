package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerDocentes extends OpcionDeMenu{
	private String nombre="VerDocentes";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		System.out.println(Archivo.verDocentes());
	}

	public String toString() {
		return "Ver docentes";
	}
	
}
