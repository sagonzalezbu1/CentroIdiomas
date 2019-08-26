package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;

public class VerHorarioDocentePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del docente: ");
			try{
				Main.ventanaUsuario.ver(Archivo.verHorarioDocente(Long.parseLong(cedula)));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error en la entrada de datos" , JOptionPane.WARNING_MESSAGE);
			}
		}else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
