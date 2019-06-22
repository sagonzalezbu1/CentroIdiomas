package uiMain;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;


import java.util.Scanner;
public class Matricular extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = e.next();
		boolean b = false;
		Curso curso=null;
		for( Curso x : Archivo.getCursos()) {
			if(x.getNombreCurso().equals(nombre)) {
				b=true;
				curso=x;
				break;
			}
		}
		if(b==false) {
			System.out.println("No se encontró el curso"+"\n");
			UsIn.getMenu().lanzarMenu();
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
		return "Matricular";
	}
}
