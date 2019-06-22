package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.*;

public class VerMisSolicitudes extends OpcionDeMenu {
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		if (Main.user instanceof Estudiante) {
			System.out.println(((Estudiante) Main.user).verSolicitudes());
		} else if (Main.user instanceof Docente) {
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
			for (Estudiante x : Archivo.getEstudiantes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.verSolicitudes());
				}
			}
		} else if (Main.user instanceof Administrativo) {
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
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