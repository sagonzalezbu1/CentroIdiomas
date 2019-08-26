package control;

import java.awt.event.*;
import java.util.*;

import BaseDatos.Archivo;
import modelo.Usuarios.*;
import modelo.excepciones.Excepcion2;
import modelo.excepciones.loginInvalido;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el método ingresar localizado en la clase Invitado.*/
public class ControlIngresarUser implements ActionListener {
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("Usuario Comun")) {
			Main.ventanaLogin.ingresarUser();
		}

		if (evento.getActionCommand().equals("Usuario ComunLogin")) {
			String mensaje = "";
			try {
				long cedula = Main.ventanaLogin.getCedula();
				String contraseña = Main.ventanaLogin.getContrasena();
				mensaje = Archivo.ingresarUsuario(cedula, contraseña);
				if (cedula == -1 || contraseña.equals("")) {
					throw new Excepcion2();
				} else if (!mensaje.equals("Se ha iniciado sesion.")) {
					throw new loginInvalido();
				}
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(), Main.user.getNombre());
			} catch (Excepcion2 excepcion) {
				Main.ventanaLogin.borrar("Campos vacios");
			} catch (loginInvalido exception) {
				Main.ventanaLogin.borrar(mensaje);
			}

		}
	}
}