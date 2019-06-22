package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;

public class VerDocentes extends OpcionDeMenu{
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verDocentes();
		volverMenu();
	}

	public String toString() {
		return " Ver docentes";
	}
	
}
