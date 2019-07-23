package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.Estudiante;

public class ResponderSolicitudes extends OpcionDeMenu {
	private String nombre = "ResponderSolicitudes";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		// Se busca la lista de solicitudes de cierto curso
		Scanner entry = new Scanner(System.in);
		if(!Archivo.verSolicitudes().equals("\nSolicitudes:\n")) {
		System.out.println(Archivo.verSolicitudes());
		System.out.println("Ingrese el tipo de la materia que desea responder solicitudes: ");
		String tipo = entry.next();
		ArrayList<Solicitud> aux1 = Archivo.getSolicitudes().get(tipo);
		// Evalúa cada solicitud
		if (aux1 != null) {
			while(aux1.size() > 0) {
				Curso course = Archivo.cursoDisponibilidad(tipo);
				Solicitud x= aux1.get(0);
				System.out.println("Tiene una solicitud de: " + x.getEstudiante().getCedula());
				System.out.println("Ingrese: 1 para aceptar, 2 para rechazar, 3 para no responder más solicitudes");
				int op = entry.nextInt();
				// Acepta, matricula al estudiante y elimina la solicitud
				if (op == 1) {
					if (course == null) {
						System.out.println("\nSe creara un curso.");
						(Main.funcionalidades.get("CrearCurso")).ejecutar();
						course = Archivo.cursoDisponibilidad(tipo);
						course.matricular(x.getEstudiante());
						Archivo.removeSolicitud(tipo, x); 
						(x.getEstudiante()).removeSolicitud(tipo);
						System.out.println("\nSe ha aceptado la solicitud exitosamente.\n");
					} else {
						course.matricular(x.getEstudiante());
						 Archivo.removeSolicitud(tipo, x); 
						 (x.getEstudiante()).removeSolicitud(tipo);
						System.out.println("\nSe ha aceptado la solicitud exitosamente.\n");
					}

				}
				// Rechaza y elimina la solicitud
				else if (op == 2) {
					Archivo.removeSolicitud(tipo, x); 
					(x.getEstudiante()).removeSolicitud(tipo);
					System.out.println("\nSe ha rechazado la solicitud exitosamente.\n");
				}
				// No responde
				else {
					System.out.println("\nHa decidido no responder mas solicitudes.\n");
					return;
				}
			}
			System.out.println("No hay mas solicitudes de este tipo.\n");
		} else {
			System.out.println("No hay solicitudes de este tipo.\n");
		}
		}else {
			System.out.println("\nNo hay solicitudes.\n");
		}

	}

	public String toString() {
		return "Responder solicitudes";
	}
}