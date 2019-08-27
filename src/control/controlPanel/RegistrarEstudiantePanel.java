package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.CodigoIncorrecto;
import modelo.excepciones.UsuarioRegistrado;

public class RegistrarEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre: ");
				String apellido = Main.ventanaUsuario.getPanelP().getValue("Apellido: ");
				long cedula = Long.parseLong(Main.ventanaUsuario.getPanelP().getValue("Cedula: ")); 
				String correo = Main.ventanaUsuario.getPanelP().getValue("Correo: ");
				String contrasena = Main.ventanaUsuario.getPanelP().getValue("Contraseña: ");
				String aviso = Archivo.registrarEstudiante(nombre, apellido, cedula, correo, contrasena);
				Main.ventanaUsuario.Popup2(aviso);
				Main.ventanaUsuario.setPanelP();
			}
			catch (CampoVacio exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}	
			catch(UsuarioRegistrado exception2) {
				Main.ventanaUsuario.Popup(exception2.getMessage());
			}
		}
		else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
