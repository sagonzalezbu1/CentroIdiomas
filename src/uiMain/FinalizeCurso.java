package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class FinalizeCurso extends OpcionDeMenu {
	private String nombre="FinalizeCurso";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se busca el curso, si se encuentra se cierra el período de calificaciones del curso
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso que desea finalizar: ");
		String nombre = e.next();
		Curso curso = null;
		for (Curso x : Archivo.getCursos()) {
			if (x.getNombreCurso().equals(nombre)) {
				curso = x;
				break;
			}
		}
		if (curso == null) {
			System.out.println("\nNo se encontró el curso\n");
		} else {
			curso.finalizeCurso();
			System.out.println("\nEl curso ha sido finalizado.\n");
		}
	}

	public String toString() {
		return "Finalizar curso";
	}
}