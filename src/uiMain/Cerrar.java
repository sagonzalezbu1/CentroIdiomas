package uiMain;

import BaseDatos.*;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;

public class Cerrar extends OpcionDeMenu {
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