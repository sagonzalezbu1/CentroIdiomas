package uiMain;
import gestorAplicacion.Centro.Archivo;

public class VerAdministradores extends OpcionDeMenu {
	public void ejecutar() {
		Archivo.verAdministrativos();
	}

	public String toString() {
		return " Ver administrativos";
	}
}
