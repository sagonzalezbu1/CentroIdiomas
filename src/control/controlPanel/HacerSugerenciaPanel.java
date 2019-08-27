package control.controlPanel;

import java.awt.event.*;

import control.*;
import modelo.excepciones.*;
import modelo.Centro.*;
import modelo.Usuarios.*;

public class HacerSugerenciaPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				Usuario Usuario = Main.user;
				String sugerencia = Main.ventanaUsuario.getPanelP().getValue("Escriba la sugerencia: ");
				Main.ventanaUsuario.ver(Sugerencia.hacerSugerencia(Usuario, sugerencia));
			} catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}

		else if(evento.getActionCommand().equals("Borrar") ) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}