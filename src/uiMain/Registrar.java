package uiMain;

import gestorAplicacion.usuarios.*;
import gestorAplicacion.Centro.*;
import java.util.*;

public class Registrar extends OpcionDeMenu {

	MenuDeConsola m= new MenuDeConsola();
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		m.anadirOpcion(new RegistrarEstudiante());
		m.anadirOpcion(new RegistrarDocente());
		m.anadirOpcion(new RegistrarAdministrativo());
		m.lanzarMenu();
	}
	
	public String toString() {
		return "Registrar";
	}
}