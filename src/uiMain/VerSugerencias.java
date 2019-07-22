package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class VerSugerencias extends OpcionDeMenu {

	private String nombre = "VerSugerencias";
	
	public String getNombre(){
		return nombre;
	}
	
	public void ejecutar(){
		String m = Archivo.verSugerencias();
		if(m.equals("")){
			System.out.println("\nNo hay sugerencias.\n");
		}else{
			System.out.println("\nlas sugerencias son: \n");
			System.out.println(m);
		}
	}
	
	public String toString(){
		return "Ver sugerencias";
	}

}
