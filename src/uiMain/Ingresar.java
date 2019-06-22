package uiMain;

import java.util.*;
import gestorAplicacion.usuarios.*;

public class Ingresar extends OpcionDeMenu {

	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese su cedula :");
		long cc = entry.nextInt();
		System.out.println("Ingrese su contraseņa :");
		String pass = entry.next();
		UsIn = Invitado.ingresar(cc, pass);
		if (UsIn == null) {
			System.out.println("Su usuario o contraseņa no son invalidos.");
			Invitado.getMenu().lanzarMenu();
			int op= entry.nextInt();
			Invitado.getMenu().ejecutarOpcion(op);
		}

		if (UsIn instanceof Estudiante) {
			((Estudiante) UsIn).getMenu().lanzarMenu();
			int op = entry.nextInt();
			((Estudiante) UsIn).getMenu().ejecutarOpcion(op);
		} else if (UsIn instanceof Docente) {
			((Docente) UsIn).getMenu().lanzarMenu();
			int op = entry.nextInt();
			((Estudiante) UsIn).getMenu().ejecutarOpcion(op);
		} else {
			((Administrativo) UsIn).getMenu().lanzarMenu();
			int op = entry.nextInt();
			((Estudiante) UsIn).getMenu().ejecutarOpcion(op);
		}

	}

	public String toString() {
		return "Ingresar";
	}
}
