package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Centro.Curso;
import gestorAplicacion.Usuarios.Estudiante;

import java.util.*;

public class ResponderSolicitudes extends OpcionDeMenu {
	String nombre="ResponderSolicitudes";
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el tipo de la materia que desea aceptar solicitudes: ");
		String tipo = entry.next();
		ArrayList<Estudiante> aux1 = Archivo.getSolicitudes().get(tipo);
		
		for (Estudiante x : aux1) {
			Curso course = Archivo.CursoDisponibilidad(tipo);
			System.out.println("Ingrese :\n1 para aceptar\n2 para rechazar\n3 no responder mas solicitudes");
			int op = entry.nextInt();
			if (op == 1) {
				if (course == null) {
					(Main.funcionalidades.get("CrearCurso")).ejecutar();
					course= Archivo.CursoDisponibilidad(tipo);
					course.matricular(x);
					Archivo.removeSolicitud(tipo, x);
					x.removeSolicitud(tipo);
				} else {
					course.matricular(x);
					Archivo.removeSolicitud(tipo, x);
					x.removeSolicitud(tipo);
				}

			} else if (op == 2) {
				Archivo.removeSolicitud(tipo, x);
				x.removeSolicitud(tipo);
			} else {
				break;
			}
			
		}
		System.out.println("No hay mas solicitudes de este tipo");
	}

	public String toString() {
		return "Responder solicitudes";
	}
}
