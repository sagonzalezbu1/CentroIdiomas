package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.usuarios.*;

public class VerEstudiantes extends OpcionDeMenu{
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verEstudiantes();
		volverMenu();
	}

	public String toString() {
		return " Ver estudiantes";
	}
}
