package uiMain;

import java.util.Scanner;

import gestorAplicacion.Usuarios.*;

public abstract class OpcionDeMenu {
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public abstract void ejecutar();
	public abstract String toString();

}
