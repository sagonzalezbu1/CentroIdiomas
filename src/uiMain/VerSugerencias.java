package uiMain;

import BaseDatos.Archivo;

/* La clase 'VerSugerencias' es donde mostramos a los usuarios el nombre de quien realizo una sugerencia seguido de la sugerencia
 * que realizo. Esto para cada una de las sugerencias localizadas en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSugerencias. */
public class VerSugerencias extends OpcionDeMenu {
	private String nombre = "VerSugerencias";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre(){
		return nombre;
	}
	
	/*En este metodo verificamos si hay sugerencias realizadas por medio de lo que nos devuelve 'verSugerencias'. 
	 * Si hay sugerencias, las mostramos; sino informamos de ello al usuario. Este metodo no recibe ningun parametro. */
	public void ejecutar(){
		String sugerencias = Archivo.verSugerencias();
		if(sugerencias.equals("\nSugerencias:\n")){
			System.out.println("\nNo hay sugerencias.\n");
		}else{
			System.out.println(sugerencias);
		}
	}
	
	/* Sobreescribimos el metodo de 'Object''toString'. */
	public String toString(){
		return "Ver sugerencias";
	}

}
