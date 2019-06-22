package uiMain;

import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;
import java.util.*;

public class VerHorario extends OpcionDeMenu {
	public void ejecutar() {
		if (Main.user instanceof Estudiante) {
			System.out.println(((Estudiante) Main.user).miHorario());
		} else if (Main.user instanceof Docente) {
			System.out.println(((Docente) Main.user).miHorario());
		} else if (Main.user instanceof Administrativo) {
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese la cedula de quien quiere ver el horario: ");
			long ID = entry.nextLong();
			for (Docente x : Archivo.getDocentes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.miHorario());
					break;
				}
			}
			for (Estudiante y : Archivo.getEstudiantes()) {
				if (y.getCedula() == ID) {
					System.out.println(y.miHorario());
					break;
				}
			}

		}
	}

	public String toString() {
		return "Mi horario";
	}
}