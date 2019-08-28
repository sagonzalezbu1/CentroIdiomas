package control.controlLogin;

import java.awt.event.*;
import java.util.*;


import defecto.Main;
import modelo.Usuarios.*;
import modelo.excepciones.control.Excepcion2;
import modelo.excepciones.modelo.LoginInvalido;

/*Esta clase es usada por todos los usuarios para ingresar a sus respectivas cuentas.
 * 
 * En esta clase se ejecuta el m�todo ingresar localizado en la clase Invitado.*/
public class ControlIngresarUser implements ActionListener {
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("Usuario Comun")) {
			Main.ventanaLogin.ingresarUser();
		}

		if (evento.getActionCommand().equals("Usuario ComunLogin")) {
			String mensaje = "";
			try {
				long cedula = Main.ventanaLogin.getCedula();
				String contrase�a = Main.ventanaLogin.getContrasena();
				mensaje = Administrador.ingresarUsuario(cedula, contrase�a);
				if (cedula == -1 || contrase�a.equals("")) {
					throw new Excepcion2();
				} else if (!mensaje.equals("Se ha iniciado sesion.")) {
					throw new LoginInvalido();
				}
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(), Main.user.getNombre());
			} catch (Excepcion2 excepcion) {
				Main.ventanaLogin.borrar(excepcion.getMessage());
			} catch (LoginInvalido exception) {
				Main.ventanaLogin.borrar(mensaje);
			}

		}
	}
}