package control.controlMenu.ayuda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import defecto.Main;

public class AcercaDe implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Acerca de")) {
			Main.ventanaUsuario.Popup2("El nombre de los autores son: \nSantiago Gonzales\nLuis Antonio Suarez Bula\nDavid Perez Zapata\nCatherin Pati�o Restrepo");
			Main.ventanaUsuario.setPanelP();
		}
	}
}