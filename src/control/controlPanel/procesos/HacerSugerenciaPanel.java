package control.controlPanel.procesos;

import java.awt.event.*;

import control.*;
import defecto.Main;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.Centro.*;
import modelo.Usuarios.*;

public class HacerSugerenciaPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				Usuario Usuario = Main.user;
				String textoSugerencia = Main.ventanaUsuario.getPanelP().getValue("Escriba la sugerencia: ");
				String sugerencia = Sugerencia.hacerSugerencia(Usuario, textoSugerencia);
				
				Main.ventanaUsuario.Popup2(sugerencia);
				Main.ventanaUsuario.setPanelP();
				
			} catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}

		else if(evento.getActionCommand().equals("Borrar") ) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}