package uiMain;

import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Registrar extends OpcionDeMenu {

	MenuDeConsola m;
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		m.anadirOpcion(new RegistrarEstudiante());
		m.anadirOpcion(new RegistrarDocente());
		m.anadirOpcion(new RegistrarAdministrativo());
		m.lanzarMenu();
		int eleccion = entrada.nextInt();
		m.ejecutarOpcion(eleccion);
	}
	
	public String toString() {
		return "Registrar";
	}
}