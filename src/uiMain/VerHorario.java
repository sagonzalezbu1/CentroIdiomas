package uiMain;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;
import java.util.*;

public class VerHorario extends OpcionDeMenu {
	public void ejecutar() {
		if(Main.user instanceof Estudiante) {
			System.out.println(((Estudiante)Main.user).miHorario());
		}
		else if (Main.user instanceof Docente){
			System.out.println(((Docente)Main.user).miHorario());
		}
	}
	public String toString() {
		return "Mi horario";
	}
}
