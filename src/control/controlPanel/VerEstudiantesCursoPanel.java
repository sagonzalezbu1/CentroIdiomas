package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;

public class VerEstudiantesCursoPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
			try{
				Main.ventanaUsuario.ver(Archivo.verEstudiantesCurso(nombre));
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, e, "Error en la entrada de datos" , JOptionPane.WARNING_MESSAGE);
			}
		}else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
	
}
