package control;

import java.awt.event.*;
import java.util.*;

import BaseDatos.Archivo;
import modelo.Usuarios.*;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el método ingresar localizado en la clase Invitado.*/
public class ControlIngresar implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("entrar")) {
			long cedula =  Main.ventana1.getCedula();
			String contraseña = Main.ventana1.getContrasena();
			Archivo.ingresarUsuario(cedula, contraseña);
			Main.ventana1.setVisible(false);
			Main.ventana2.setVisible(true);
			
		}
	}

	
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