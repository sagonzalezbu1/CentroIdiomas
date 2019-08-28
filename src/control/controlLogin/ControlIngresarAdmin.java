package control.controlLogin;

import java.awt.event.*;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.excepciones.Excepcion1;
import modelo.excepciones.LoginInvalido;

public class ControlIngresarAdmin implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Administrador")) {
			Main.ventanaLogin.ingresarAdmin();
		}
		if (evento.getActionCommand().equals("AdministradorLogin")) {
			String mensaje="";
			try {
				long cedula = Main.ventanaLogin.getCedula();
				String contraseņa = Main.ventanaLogin.getContrasena();
				mensaje = Archivo.ingresarAdmin(cedula, contraseņa);
				
				if (cedula == -1 || contraseņa.equals("")) {
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
