package control.controlPanel;

import java.awt.event.*;
import control.*;
import defecto.Main;
import modelo.excepciones.*;

public class UsuarioPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre: ");
				String correo = Main.ventanaUsuario.getPanelP().getValue("Correo: ");
				String contrasena = Main.ventanaUsuario.getPanelP().getValue("Contraseña: ");
				
				Main.user.setNombre(nombre);
				Main.user.setCorreo(correo);
				Main.user.setContrasena(contrasena);
				
				Main.ventanaUsuario.Popup2("Se han guardado los datos correctamente.");
				Main.ventanaUsuario.setPanelP();
			} catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
				
			}
		}
		else if(evento.getActionCommand().equals("Borrar") ) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula: ");
				Main.ventanaUsuario.getPanelP().borrar2(cedula, 1);
			} catch(CampoVacio excepcion) {
			}
		}
	}
}