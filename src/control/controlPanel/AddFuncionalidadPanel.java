package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import modelo.Usuarios.Administrador;
import modelo.excepciones.CampoVacio;

public class AddFuncionalidadPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
			long CC= Long.parseLong(Main.ventanaUsuario.getPanelP().getValue("Cedula del Usuario: "));
			String funcion= Main.ventanaUsuario.getPanelP().getValue("Funcionalidad a añadir: ");
			String mensaje=((Administrador)Main.user).addFuncionalidad(CC,funcion);
			Main.ventanaUsuario.Popup2(mensaje);
			}catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup2("Campo vacio");
			}
		}else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
		
	}

}
