package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Administrativo para responder a las solicitudes de cupo
 * que hagan los estudiantes a los cursos que no tengan cupos.*/
public class ResponderSolicitudes extends OpcionDeMenu {
	private String nombre = "ResponderSolicitudes";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}

	/*Se muestran por pantalla las solicitudes disponibles y se da la opción de aceptar, rechazar e ignorar.
	 * Al aceptar se matricula al estudiante y se elimina la solicitud, al rechazar sólo se elimina la solicitud, 
	 * y al ignorar sólo se sale de la opción.*/
	public void ejecutar() {
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
				else if (op == 2) {
					Archivo.removeSolicitud(tipo, x); 
					(x.getEstudiante()).removeSolicitud(tipo);
					System.out.println("\nSe ha rechazado la solicitud exitosamente.\n");
				}
				else {
					System.out.println("\nHa decidido no responder mas solicitudes.\n");
					return;
				}
			}
			System.out.println("No hay mas solicitudes de este tipo.\n");
		} else {
			System.out.println("No hay solicitudes de este tipo.\n");
		}
		} else {
			System.out.println("\nNo hay solicitudes.\n");
		}

	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Responder solicitudes";
	}
}