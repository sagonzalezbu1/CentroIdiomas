package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;

public class VerHorarioEstudiantePanel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
			try{
				Main.ventanaUsuario.ver(Archivo.verHorarioEstudiante(Long.parseLong(cedula)));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error al iniciar sesion" , JOptionPane.WARNING_MESSAGE);
			}
		}else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
