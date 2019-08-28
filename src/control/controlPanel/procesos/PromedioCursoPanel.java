package control.controlPanel.procesos;

import java.awt.event.*;

import defecto.Main;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoHayEstudiantes;
import modelo.excepciones.modelo.NoHayNotas;
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
		else if(evento.getActionCommand().equals("Borrar") ) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}