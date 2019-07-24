package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Invitado para finalizar la ejecución del programa.*/
public class Salir extends OpcionDeMenu {
	
	/*Antes de salir del programa se guarda toda la información de los 
	 * objetos en los archivos de texto para la próxima vez que se inicie*/
	public void ejecutar() {
		Data.escribirDocentes();
		Data.escribirEstudiantes();
		Data.escribirAdministrativos();
		Data.escribirSolicitudes();
		Data.escribirCursos();
		Data.escribirSugerencias();
		System.out.println("El programa se ha cerrado.");
		System.exit(0);
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Salir del programa";
	}
}