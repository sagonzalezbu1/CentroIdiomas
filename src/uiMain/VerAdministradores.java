package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.*;

public class VerAdministradores extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verAdministrativos();
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
		return " Ver administrativos";
	}
}
