package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.Estudiante;

public class ResponderSolicitudes extends OpcionDeMenu {
	private String nombre="ResponderSolicitudes";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se busca la lista de solicitudes de cierto curso
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el tipo de la materia que desea aceptar solicitudes: ");
		String tipo = entry.next();
		ArrayList<Solicitud> aux1 = Archivo.getSolicitudes().get(tipo);
		//Eval�a cada solicitud
		for (Solicitud x : aux1) {
			Curso course = Archivo.CursoDisponibilidad(tipo);
			System.out.println("Ingrese :\n1 para aceptar\n2 para rechazar\n3 para no responder m�s solicitudes");
			int op = entry.nextInt();
			//Acepta, matricula al estudiante y elimina la solicitud
			if (op == 1) {
				if (course == null) {
					(Main.funcionalidades.get("CrearCurso")).ejecutar();
					course= Archivo.CursoDisponibilidad(tipo);
					course.matricular(x.getEstudiante());
					Archivo.removeSolicitud(tipo, x.getEstudiante());
					(x.getEstudiante()).removeSolicitud(tipo);
				}
				else {
					course.matricular(x.getEstudiante());
					Archivo.removeSolicitud(tipo, x.getEstudiante());
					(x.getEstudiante()).removeSolicitud(tipo);
				}

			}
			//Rechaza y elimina la solicitud
			else if (op == 2) {
				Archivo.removeSolicitud(tipo, x.getEstudiante());
				(x.getEstudiante()).removeSolicitud(tipo);
			}
			//No responde
			else {
				return;
			}
		}
		System.out.println("No hay mas solicitudes de este tipo");
	}

	public String toString() {
		return "Responder solicitudes";
	}
}