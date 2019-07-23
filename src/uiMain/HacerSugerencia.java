package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class HacerSugerencia extends OpcionDeMenu {
	private String nombre = "HacerSugerencia";
	
	public String getNombre(){
		return nombre;
	}
	
	public void ejecutar(){
		Scanner e = new Scanner(System.in);
		System.out.println("Escriba su sugerencia (en una sola linea): ");
		String s = e.nextLine();
		new Sugerencia(Main.user ,s);
		System.out.println("");
		System.out.println("Su sugerencia fue enviada con exito.");
		System.out.println("");
	}
	
	public String toString(){
		return "Hacer sugerencia";
	}
}
