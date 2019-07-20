package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerAdministrativos extends OpcionDeMenu {
	private String nombre="VerAdministrativos";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		if (Archivo.verAdministrativos().equals("")) {
			System.out.println("No hay administrativos registrados.\n");
		} else {
			System.out.println(Archivo.verAdministrativos());
		}
	}

	public String toString() {
		return "Ver administrativos";
	}
}
