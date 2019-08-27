package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.NoExisteEstudiante;

public class SolicitarCupoEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		try {
			if(evento.getActionCommand().equals("Aceptar")){
				String cc = Main.ventanaUsuario.getPanelP().getValue("Cedula del Estudiante: ");
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo del curso: ");
				String solicitud = Archivo.buscarEstudiante(Long.parseLong(cc)).solicitarCupo(Long.parseLong(cc),tipo);
				Main.ventanaUsuario.Popup(solicitud);
				Main.ventanaUsuario.getPanelP().borrar();
			}
		}
		catch(NoExisteEstudiante exception) {
			Main.ventanaUsuario.Popup("Estudiante no encontrado");
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
