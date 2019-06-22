package uiMain;
import gestorAplicacion.usuarios.*;
public class VerHorario extends OpcionDeMenu {
	public void ejecutar() {
		((Estudiante) UsIn).miHorario();
	}
	public String toString() {
		return "Mi horario";
	}
}
