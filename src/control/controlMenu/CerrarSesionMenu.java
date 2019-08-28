package control.controlMenu;

import java.awt.event.*;
import control.*;
import vista.*;


/*Esta clase es usada por todos los usuarios para volver al menú de Invitado*/
public class CerrarSesionMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Salir")) {
			Main.ventanaUsuario.setVisible(false);;
			Main.ventanaLogin.setVisible(true);
			Main.ventanaUsuario = new ventanaUsuario();
		}
	}
}