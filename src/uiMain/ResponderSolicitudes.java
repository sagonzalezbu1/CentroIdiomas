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
		System.out.println(Archivo.verSolicitudes());
		System.out.println("Ingrese el tipo de la materia que desea responder solicitudes: ");
		String tipo = entry.next();
		ArrayList<Solicitud> aux1 = Archivo.getSolicitudes().get(tipo);
		ArrayList<Solicitud> s = new ArrayList<Solicitud>();
		// Evalúa cada solicitud
		if (aux1 != null) {
			for (Solicitud x : aux1) {
				Curso course = Archivo.CursoDisponibilidad(tipo);
				System.out.println("Tiene una solicitud de: " + x.getEstudiante().getCedula());
				System.out.println("Ingrese: 1 para aceptar, 2 para rechazar, 3 para no responder más solicitudes");
				int op = entry.nextInt();
				// Acepta, matricula al estudiante y elimina la solicitud
				if (op == 1) {
					if (course == null) {
						System.out.println("Se creara un curso.");
						(Main.funcionalidades.get("CrearCurso")).ejecutar();
						course = Archivo.CursoDisponibilidad(tipo);
						course.matricular(x.getEstudiante());
						s.add(x);
						/*
						 * Archivo.removeSolicitud(tipo, x); (x.getEstudiante()).removeSolicitud(tipo);
						 */
						System.out.println("Se ha aceptado la solicitud exitosamente.\n");
					} else {
						course.matricular(x.getEstudiante());
						s.add(x);
						/*
						 * Archivo.removeSolicitud(tipo, x); 
						 * (x.getEstudiante()).removeSolicitud(tipo);
						 */
						System.out.println("Se ha aceptado la solicitud exitosamente.\n");
					}

				}
				// Rechaza y elimina la solicitud
				else if (op == 2) {
					s.add(x);
					System.out.println("Se ha rechazado la solicitud exitosamente.\n");
				}
				// No responde
				else {
					System.out.println("Ha decididono responder mas solicitudes.\n");
					for (Solicitud y : s) {
						Archivo.removeSolicitud(tipo, y);
						(y.getEstudiante()).removeSolicitud(tipo);
					}
					s.clear();
					return;
				}
			}
			//borrarlos de archivo
			for (Solicitud x : s) {
				Archivo.removeSolicitud(tipo, x);
				(x.getEstudiante()).removeSolicitud(tipo);
			}
			s.clear();
			System.out.println("No hay mas solicitudes de este tipo.\n");
		} else {
			System.out.println("No hay solicitudes de este tipo.\n");
		}

	}

	public String toString() {
		return "Responder solicitudes";
	}
}