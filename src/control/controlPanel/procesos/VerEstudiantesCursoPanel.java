package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import defecto.Main;
import modelo.Centro.Curso;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoHayEstudiantes;

public class VerEstudiantesCursoPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				Main.ventanaUsuario.ver(Curso.verEstudiantesCurso(nombre));
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteCurso excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoHayEstudiantes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
