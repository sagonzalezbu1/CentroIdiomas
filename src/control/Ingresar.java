package control;

import java.util.*;

import modelo.Usuarios.*;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el método ingresar localizado en la clase Invitado.*/
public class Ingresar extends OpcionDeMenu {
	
	/*Se inicia sesión con los datos del usuario, es decir, se ejecuta el menú del
	* respectivo usuario*/
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese su cedula:");
		long cc = entry.nextInt();
		System.out.println("Ingrese su contraseña:");
		String pass = entry.next();
		Invitado.ingresar(cc, pass);
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Ingresar";
	}
}