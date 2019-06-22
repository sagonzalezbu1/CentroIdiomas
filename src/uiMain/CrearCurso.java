package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;

public class CrearCurso extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = e.next();
		System.out.println("Ingrese el horario del curso: ");
		String horario = e.next();
		System.out.println("Ingrese la cedula del docente que dará el curso: ");
		long cc = e.nextLong();
		Docente docente=null;
		boolean b = false;
		for(Docente x : Archivo.getDocentes()) {
			if(cc==x.getCedula()) {
				b=true;
				docente=x;
			}
		}
		if(b=true) {
			System.out.println("Ingrese el tipo del curso(ingles,aleman,mandarin...): "); 
			String tipo = e.next();
			new Curso(nombre,horario,docente,tipo);
		}
		else {
			System.out.println("El docente no existe");
		}
		
	}

	public String toString() {
		return "Crear Curso";
	}
}
