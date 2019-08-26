package control.controlPanel;
import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.Usuarios.*;

import control.Main;
public class SolicitarCupoPanel implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo de la Solicitud: ");
			String solicitud = ((Estudiante)(Main.user)).solicitarCupo(Main.user.getCedula(), tipo);
			
			JOptionPane.showMessageDialog(null, solicitud, "Aviso" , JOptionPane.WARNING_MESSAGE);

		}
		else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
