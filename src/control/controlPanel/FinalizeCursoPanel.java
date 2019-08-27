package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.NoExisteCurso;

public class FinalizeCursoPanel implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				String aviso = Archivo.FinalizeCurso(nombre);
				Main.ventanaUsuario.Popup2(aviso);
				Main.ventanaUsuario.setPanelP();
				
			} catch (CampoVacio exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			} catch (NoExisteCurso exception2) {
				Main.ventanaUsuario.Popup(exception2.getMessage());
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}