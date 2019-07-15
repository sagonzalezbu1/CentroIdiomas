package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Salir extends OpcionDeMenu {
	String nombre="";
	public void ejecutar() {
		Data.escribirDocentes();
		Data.escribirEstudiantes();
		Data.escribirAdministrativos();
		System.exit(0);
	}
	public String toString() {
		return "Salir del programa";
	}
}