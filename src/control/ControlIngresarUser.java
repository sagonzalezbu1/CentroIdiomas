package control;

import java.awt.event.*;
import java.util.*;

import BaseDatos.Archivo;
import modelo.Usuarios.*;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el método ingresar localizado en la clase Invitado.*/
public class ControlIngresarUser implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getActionCommand().equals("Usuario Comun")) {
			Main.ventanaLogin.ingresarUser();
		}

		if (evento.getActionCommand().equals("Usuario ComunLogin")) {
			long cedula = Main.ventanaLogin.getCedula();
			String contraseña = Main.ventanaLogin.getContrasena();
			String mensaje = Archivo.ingresarUsuario(cedula, contraseña);
			if (mensaje.equals("Se ha iniciado sesion.")) {
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(), Main.user.getNombre());
			} else {
				Main.ventanaLogin.borrar(mensaje);
			}

		}
	}
}