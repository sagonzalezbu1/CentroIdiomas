package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;

public class VerSolicitudes extends OpcionDeMenu {
	private String nombre = "VerSolicitudes";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		// Verifica qué tipo de usuario verá solicitudes
		if (Main.user instanceof Estudiante) {
			// Si es estudiante le mostrará sus solicitudes
			String aux = ((Estudiante) Main.user).verSolicitudes();
			if (aux.equals("")) {
				System.out.println("Usted no tiene solicitudes.\n");
			} else {
				System.out.println(aux+"\n");
			}
		} else {
			// Si es otro le preguntará de qué estudiante mostrar las solicitudes
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
			Estudiante e = Archivo.buscarEstudiante(ID);
			if(e==null) {
				System.out.println("Este estudiante no esta registrado.\n");
			}else {
				String aux = e.verSolicitudes();
				if(aux.equals("")){
					System.out.println("Este estudiante aun no tiene Solicitudes.\n");
				}else {
					System.out.println(aux+"\n");
				}
			}

		}
	}

	public String toString() {
		return "Ver Solicitudes";
	}
}