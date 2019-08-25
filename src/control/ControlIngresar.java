package control;

import java.awt.event.*;
import java.util.*;

import BaseDatos.Archivo;
import modelo.Usuarios.*;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el m�todo ingresar localizado en la clase Invitado.*/
public class ControlIngresar implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("entrar")) {
			long cedula =  Main.ventana1.getCedula();
			String contrase�a = Main.ventana1.getContrasena();
			Archivo.ingresarUsuario(cedula, contrase�a);
			Main.ventana1.setVisible(false);
			Main.ventana2.setVisible(true);
			
		}
	}

	
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