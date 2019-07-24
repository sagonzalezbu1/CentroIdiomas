package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Invitado para finalizar la ejecuci�n del programa.*/
public class Salir extends OpcionDeMenu {
	
	/*Antes de salir del programa se guarda toda la informaci�n de los 
	 * objetos en los archivos de texto para la pr�xima vez que se inicie*/
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
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Salir del programa";
	}
}