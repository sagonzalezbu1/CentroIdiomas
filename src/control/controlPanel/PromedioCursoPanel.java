package control.controlPanel;

import java.awt.event.*;
import control.Main;
import modelo.excepciones.*;
import modelo.Centro.*;

public class PromedioCursoPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombreCurso = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				Main.ventanaUsuario.ver(Curso.promedioCurso(nombreCurso));
			} catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch(NoHayNotas excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch(NoHayEstudiantes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteCurso excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}