package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerAdministrativos extends OpcionDeMenu {
	String nombre="VerAdministrativos";
	public void ejecutar() {
		System.out.println(Archivo.verAdministrativos());
	}

	public String toString() {
		return "Ver administrativos";
	}
}
