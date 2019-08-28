package control.controlLogin;

import java.awt.event.*;


import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.excepciones.control.Excepcion1;
import modelo.excepciones.modelo.LoginInvalido;

public class ControlIngresarAdmin implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Administrador")) {
			Main.ventanaLogin.ingresarAdmin();
		}
		if (evento.getActionCommand().equals("AdministradorLogin")) {
			String mensaje="";
			try {
				long cedula = Main.ventanaLogin.getCedula();
				String contrase�a = Main.ventanaLogin.getContrasena();
				mensaje = Administrador.ingresarAdmin(cedula, contrase�a);
				
				if (cedula == -1 || contrase�a.equals("")) {
					throw new Excepcion1();
				}else if(!mensaje.equals("Se ha iniciado sesion.")) {
					throw new LoginInvalido();
				}
				
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(), Main.user.getNombre());

			} catch (Excepcion1 excepcion) {
				Main.ventanaLogin.borrar(excepcion.getMessage());
			} catch(LoginInvalido exception) {
				Main.ventanaLogin.borrar(mensaje);
			}

		}
	}

}
