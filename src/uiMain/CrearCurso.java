package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class CrearCurso extends OpcionDeMenu {
	private String nombre="CrearCurso";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se crea el curso pidiendo información de este al usuario
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = e.next();
		System.out.println("Ingrese el horario del curso (dia1-dia2_horainicio-horafinal): ");
		String horario = e.next();
		System.out.println("Ingrese la cedula del docente que dará el curso: ");
		long cc = e.nextLong();
		Docente docente=null;
		boolean b = false;
		//Se verifica que el docente que dictará el curso exista
		for(Docente x : Archivo.getDocentes()) {
			if(cc==x.getCedula()) {
				b=true;
				docente=x;
			}
		}
		if(b==true) {
			System.out.println("Ingrese el tipo del curso(ingles, aleman, mandarin,...): "); 
			String tipo = e.next(); 
			Curso busqueda= Archivo.buscarCurso(nombre);
			if(busqueda==null) {
				new Curso(nombre,tipo,horario,docente);
				System.out.println("Se ha creado el curso");
			}else {
				System.out.println("El nombre del curso no es valido");
			}
		}
		else {
			System.out.println("El docente no existe");
		}
		
	}

	public String toString() {
		return "Crear Curso";
	}
}
