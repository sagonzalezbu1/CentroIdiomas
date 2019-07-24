package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
/* La clase 'VerSugerencias' es donde mostramos a los usuarios el nombre de quien realizo una sugerencia seguido de la sugerencia
 * que realizo. Esto para cada una de las sugerencias localizadas en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSugerencias. 
 */
public class VerSugerencias extends OpcionDeMenu {

	private String nombre = "VerSugerencias";
	
	public String getNombre(){
		return nombre;
	}
	
	public void ejecutar(){
		String m = Archivo.verSugerencias();
		if(m.equals("\nSugerencias:\n")){
			System.out.println("\nNo hay sugerencias.\n");
		}else{
			System.out.println(m);
		}
	}
	
	public String toString(){
		return "Ver sugerencias";
	}

}
