package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;
/* La clase 'VerSolicitudes' es donde mostramos las solicitudes de cupo que ha realizado a un tipo de idioma un estudiante, si quien lo pregunta es de instancia 
 * diferente la instancia 'Estudiante'. Si por el contrario es un estudiante quien realiza la funcionalidad, se mostrara las solicitudes que �l ha hecho.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSolicitudes. 
 */
public class VerSolicitudes extends OpcionDeMenu {
	private String nombre = "VerSolicitudes";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		// Verifica qu� tipo de usuario ver� solicitudes
		if (Main.user instanceof Estudiante) {
			// Si es estudiante le mostrar� sus solicitudes
			String aux = ((Estudiante) Main.user).verSolicitudes();
			if (aux.equals("")) {
				System.out.println("\nUsted no tiene solicitudes.\n");
			} else {
				System.out.println("");
				System.out.println(aux+"\n");
			}
		} else {
			// Si es otro le preguntar� de qu� estudiante mostrar las solicitudes
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
			Estudiante e = Archivo.buscarEstudiante(ID);
			if(e==null) {
				System.out.println("\nEl estudiante no esta registrado.\n");
			}else {
				String aux = e.verSolicitudes();
				if(aux.equals("")){
					System.out.println("\nEl estudiante no tiene Solicitudes.\n");
				}else {
					System.out.println("");
					System.out.println(aux+"\n");
				}
			}

		}
	}

	public String toString() {
		return "Ver Solicitudes";
	}
}