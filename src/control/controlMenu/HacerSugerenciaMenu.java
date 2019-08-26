package control.controlMenu;

import java.util.*;

import control.OpcionDeMenu;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Docente y Estudiante para realizar sugerencias sobre 
 * el programa y su funcionamiento.
 * 
 * En esta clase se crean objetos de tipo Sugerencia y se 
 * les asignan sus respectivos atributos.*/
public class HacerSugerenciaMenu extends OpcionDeMenu {
	private String nombre = "HacerSugerencia";
	
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro*/
	public String getNombre(){
		return nombre;
	}
	
	/*Se crea una sugerencia con sus respectivos atributos y datos*/
	public void ejecutar(){
		Scanner entry = new Scanner(System.in);
		System.out.println("Escriba su sugerencia (en una sola linea): ");
		String sugerencia = entry.nextLine();
		new Sugerencia(Main.user ,sugerencia);
		System.out.println("");
		System.out.println("Su sugerencia fue enviada con exito.");
		System.out.println("");
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString(){
		return "Hacer sugerencia";
	}
}