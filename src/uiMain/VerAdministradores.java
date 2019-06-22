package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Archivo;

public class VerAdministradores extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e= new Scanner( System.in);
		Archivo.verAdministrativos();
		volverMenu();
	}

	public String toString() {
		return " Ver administrativos";
	}
}
