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
		//Verifica qué tipo de usuario verá el horario
		if (Main.user instanceof Estudiante) {
			//Si es estudiante le mostrará su horario
			System.out.println(((Estudiante) Main.user).miHorario());
		}
		else if (Main.user instanceof Docente) {
			//Si es docente le mostrará su horario
			System.out.println(((Docente) Main.user).miHorario());
		}
		else if (Main.user instanceof Administrativo) {
			//Si es administrativo preguntará de quién ver el horario
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese la cedula de quien quiere ver el horario: ");
			long ID = entry.nextLong();
			//Busca el usuario y muestra el respectivo horario
			for (Docente x : Archivo.getDocentes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.miHorario()+"\n");
					return;
				}
			}
			for (Estudiante y : Archivo.getEstudiantes()) {
				if (y.getCedula() == ID) {
					System.out.println(y.miHorario()+"\n");
					return;
				}
			}
			System.out.println("No se ha encontrado ningun usuario.\n");
		}
	}

	public String toString() {
		return "Ver horario";
	}
}