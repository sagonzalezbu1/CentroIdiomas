package uiMain;

import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;

import java.util.Scanner;

public class Matricular extends OpcionDeMenu {
	public void ejecutar() {

		Scanner e = new Scanner(System.in);

		if (Main.user instanceof Estudiante) {
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = e.next();
			boolean b = false;
			Curso curso = null;
			for (Curso x : Archivo.getCursos()) {
				if (x.getNombreCurso().equals(nombre)) {
					b = true;
					curso = x;
					break;
				}
			}
			if (b == false) {
				System.out.println("No se encontró el curso" + "\n");
			} else {
				boolean bool = curso.matricular((Estudiante) (Main.user));
				if(bool == true) {
					System.out.println("Usted quedó matriculado");
				}else {
					System.out.println("No hay cupos disponibles en este curso");
				}
			}
		}else {
			System.out.println("Ingrese la cedula del estudiante a matricular: ");
			long cedula =e.nextLong();
			boolean b = false;
			Estudiante estudiante = null;
			for (Estudiante x : Archivo.getEstudiantes()) {
				if (x.getCedula()==cedula) {
					b = true;
					estudiante = x;
					break;
				}
			}
			if(b=true) {
				System.out.println("Ingrese el nombre del curso donde lo quiere matricular: ");
				String nombre = e.next();
				boolean c = false;
				Curso curso = null;
				for (Curso x : Archivo.getCursos()) {
					if (x.getNombreCurso().equals(nombre)) {
						c = true;
						curso = x;
						break;
					}
				}
				if (c == false) {
					System.out.println("No se encontró el curso" + "\n");
				} else {
					boolean bool = curso.matricular((Estudiante) (Main.user));
					if(bool==true) {
						System.out.println("El estudiante quedó matriculado");
					}else {
						System.out.println("No hay cupos disponibles en este curso");
					}
				}
			}else {
				System.out.println("No se encontró el estudiante");
			}
		
		}

	}

	public String toString() {
		return "Matricular";
	}
}
