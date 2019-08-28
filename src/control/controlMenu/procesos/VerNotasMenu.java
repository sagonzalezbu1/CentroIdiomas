package control.controlMenu.procesos;

import java.awt.event.*;

import BaseDatos.*;
import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.*;
import modelo.excepciones.modelo.EstudianteSinCursos;
import modelo.excepciones.modelo.NoExisteEstudiante;

public class VerNotasMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerNotas")) {
			try {
				String notas= Estudiante.verNotasEstudiante(Main.user.getCedula());
				Main.ventanaUsuario.ver(notas);
			} catch(EstudianteSinCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}