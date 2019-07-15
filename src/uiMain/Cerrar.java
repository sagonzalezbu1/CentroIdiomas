package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Cerrar extends OpcionDeMenu {
	String nombre="";
	public void ejecutar() {
		Data.escribirDocentes();
		Data.escribirEstudiantes();
		Data.escribirAdministrativos();
		System.exit(0);
	}
	public String toString() {
		return "Cerrar programa";
	}
}