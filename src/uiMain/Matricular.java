package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

import java.util.Scanner;

public class Matricular extends OpcionDeMenu {
	private String nombre="Matricular";
	public String getNombre() {
		return nombre;
	}
	
	public void ejecutar() {
		
		Scanner e = new Scanner(System.in);
		//Se verifica qué tipo de usuario hace la matrícula
		if (Main.user instanceof Estudiante) {
			//Si es estudiante lo matricula normal
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
			//Luego se verifica que el curso en el que se quiere matricular exista
			if (b == false) {
				System.out.println("No se encontró el curso" + "\n");
			}
			else {
				boolean bool = curso.matricular((Estudiante) (Main.user));
				//Por último se verifica que haya cupos disponibles
				if(bool == true) {
					System.out.println("Usted quedó matriculado");
				}
				else {
					System.out.println("No hay cupos disponibles en este curso");
				}
			}
		}
		else {
			//Si es otro, pregunta qué estudiante matricular
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
			//Se verifica que el estudiante exista
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
				//Se verifica que el curso exista
				if (c == false) {
					System.out.println("No se encontró el curso" + "\n");
				}
				else {
					boolean bool = curso.matricular((Estudiante) (estudiante));
					if(bool==true) {
						System.out.println("El estudiante quedó matriculado");
					}
					else {
						System.out.println("No hay cupos disponibles en este curso");
					}
				}
			}
			else {
				System.out.println("No se encontró el estudiante");
			}
		}
	}

	public String toString() {
		return "Matricular";
	}
}