package control.controlLogin;

import java.awt.event.*;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.Excepcion1;
import modelo.excepciones.loginInvalido;

public class ControlIngresarAdmin implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Administrador")) {
			Main.ventanaLogin.ingresarAdmin();
		}
		if (evento.getActionCommand().equals("AdministradorLogin")) {
			String mensaje="";
			try {
				long cedula = Main.ventanaLogin.getCedula();
				String contraseña = Main.ventanaLogin.getContrasena();
				mensaje = Archivo.ingresarAdmin(cedula, contraseña);
				
				if (cedula == -1 || contraseña.equals("")) {
					throw new Excepcion1();
				}else if(!mensaje.equals("Se ha iniciado sesion.")) {
					throw new loginInvalido();
				}
				
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(), Main.user.getNombre());

			} catch (Excepcion1 excepcion) {
				Main.ventanaLogin.borrar("Campos vacios");
			} catch(loginInvalido exception) {
				Main.ventanaLogin.borrar(mensaje);
			}

		}
	}

}
