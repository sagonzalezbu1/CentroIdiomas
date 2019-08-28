package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;

public class CalificarPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			
		}
		else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
