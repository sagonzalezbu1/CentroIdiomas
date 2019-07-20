package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Salir extends OpcionDeMenu {
	public void ejecutar() {
		//Antes de salir del programa se guarda toda la información en los archivos de texto
		Data.escribirDocentes();
		Data.escribirEstudiantes();
		Data.escribirAdministrativos();
		Data.escribirSolicitudes();
		Data.escribirCursos();
		System.exit(0);
		System.out.println("El programa se ha cerrado.");
	}
	public String toString() {
		return "Salir del programa";
	}
}