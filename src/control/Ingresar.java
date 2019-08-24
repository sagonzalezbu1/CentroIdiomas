package control;

import java.util.*;

import modelo.Usuarios.*;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el m�todo ingresar localizado en la clase Invitado.*/
public class Ingresar extends OpcionDeMenu {
	
	/*Se inicia sesi�n con los datos del usuario, es decir, se ejecuta el men� del
	* respectivo usuario*/
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese su cedula:");
		long cc = entry.nextInt();
		System.out.println("Ingrese su contrase�a:");
		String pass = entry.next();
		Invitado.ingresar(cc, pass);
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Ingresar";
	}
}