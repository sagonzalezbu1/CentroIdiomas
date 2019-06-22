package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Centro.Curso;
import gestorAplicacion.usuarios.Estudiante;

public class FinalizeCurso extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e= new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso que desea finalizar: ");
		String nombre=e.next();
		Curso curso=null;
		for( Curso x : Archivo.getCursos()) {
			if(x.getNombreCurso().equals(nombre)) {
				curso=x;
				break;
			}
		}
		if(curso==null) {
			System.out.println("No se encontró el curso"+"\n");
			( UsIn).getMenu().lanzarMenu();
			int eleccion = e.nextInt();
			UsIn.getMenu().ejecutarOpcion(eleccion);
		}else {
			curso.matricular((Estudiante)(UsIn));
			System.out.println("Usted quedó matriculado");
			UsIn.getMenu().lanzarMenu();
			int eleccion = e.nextInt();
			UsIn.getMenu().ejecutarOpcion(eleccion);
		}
	}
	public String toString() {
		return "Finalizar curso";
	}
}
