package control.controlMenu;

import java.awt.event.*;

import BaseDatos.*;
import control.Main;
import modelo.excepciones.*;

public class MisNotasMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("MisNotas")) {
			try {
				String notas= Archivo.verNotasEstudiante(Main.user.getCedula());
				Main.ventanaUsuario.ver(notas);
			} catch(EstudianteSinCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}