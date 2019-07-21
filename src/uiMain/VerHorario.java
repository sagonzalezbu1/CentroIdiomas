package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

public class VerHorario extends OpcionDeMenu {
	private String nombre="VerHorario";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Verifica qu� tipo de usuario ver� el horario
		if (Main.user instanceof Estudiante) {
			//Si es estudiante le mostrar� su horario
			System.out.println("");
			System.out.println(((Estudiante) Main.user).miHorario());
		}
		else if (Main.user instanceof Docente) {
			//Si es docente le mostrar� su horario
			System.out.println(((Docente) Main.user).miHorario());
		}
		else {
			//Si es administrativo o adminsitrador preguntar� de qui�n ver el horario
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese la cedula de quien quiere ver el horario: ");
			long ID = entry.nextLong();
			//Busca el usuario y muestra el respectivo horario
			for (Docente x : Archivo.getDocentes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.miHorario());
					return;
				}
			}
			for (Estudiante y : Archivo.getEstudiantes()) {
				if (y.getCedula() == ID) {
					System.out.println("");
					System.out.println(y.miHorario());
					return;
				}
			}
			System.out.println("\nNo se ha encontrado ningun usuario.\n");
		}
	}

	public String toString() {
		return "Ver horario";
	}
}