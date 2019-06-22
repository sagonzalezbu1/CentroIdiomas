package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.Administrativo;
import gestorAplicacion.usuarios.Docente;
import gestorAplicacion.usuarios.Estudiante;
import gestorAplicacion.usuarios.Invitado;

public class VerDocentes extends OpcionDeMenu{
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verDocentes();
		if( UsIn == null) {
			Invitado.getMenu().lanzarMenu();
			int op=e.nextInt();
			Invitado.getMenu().ejecutarOpcion(op);	
		}else if(UsIn instanceof Estudiante) {
			((Estudiante) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Estudiante) UsIn).getMenu().ejecutarOpcion(op);
		}else if (UsIn instanceof Docente) {
			((Docente) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Docente) UsIn).getMenu().ejecutarOpcion(op);
		}else {
			((Administrativo) UsIn).getMenu().lanzarMenu();
			int op=e.nextInt();
			((Administrativo) UsIn).getMenu().ejecutarOpcion(op);
		}
	}

	public String toString() {
		return " Ver docentes";
	}

}
