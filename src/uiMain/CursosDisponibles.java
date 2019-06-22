package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.*;

public class CursosDisponibles extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verCursos();
		volverMenu();
	}

	public String toString() {
		return " Ver cursos disponibles";
	}
}
