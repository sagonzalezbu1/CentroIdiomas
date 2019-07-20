package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

public class SolicitarCupo extends OpcionDeMenu {
	private String nombre = "SolicitarCupo";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		// Se verifica qué tipo de usuario hace la solicitud
		if (Main.user instanceof Estudiante) {
			// Si es estudiante le hace la solicitud normal
			System.out.println("Ingrese el tipo de la materia a la cual va a solicitar el cupo: ");
			String aux = entry.next();
			if (Archivo.CursoDisponibilidad(aux) == null) {
				((Estudiante) Main.user).solicitar(aux);
				System.out.println("Su solicitud ha sido exitosa.\n");
				return;
			} else {
				System.out.println("No puede solicitar. Hay cupos disponibles.\n");
			}

		} else {
			// Si es otro, pregunta a qué estudiante se le va a solicitar
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long aux1 = entry.nextLong();
			Estudiante x= Archivo.buscarEstudiante(aux1);
			if (x != null) {
				System.out.println("Ingrese el tipo de la materia a la cual va a solicitar el cupo: ");
				String aux2 = entry.next();
				if (Archivo.CursoDisponibilidad(aux2) == null) {
					x.solicitar(aux2);
					System.out.println("Su solicitud ha sido exitosa.\n");
					return;
				} else {
					System.out.println("No puede solicitar. Hay cupos disponibles.\n");
				}
			}else {
				System.out.println("Estudiante no encontrado.\n");
			}
		}
	}

	public String toString() {
		return "Solicitar Cupo";
	}
}