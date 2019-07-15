package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;

public class VerMisSolicitudes extends OpcionDeMenu {
	private String nombre="VerMisSolicitudes";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		//Verifica qu� tipo de usuario ver� solicitudes
		if (Main.user instanceof Estudiante) {
			//Si es estudiante le mostrar� sus solicitudes
			System.out.println(((Estudiante) Main.user).verSolicitudes());
		}
		else {
			//Si es otro le preguntar� de qu� estudiante mostrar las solicitudes
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
			//Busca al estudiante
			for (Estudiante x : Archivo.getEstudiantes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.verSolicitudes());
				}
			}
		}
	}

	public String toString() {
		return "Solicitudes Pendientes";
	}
}