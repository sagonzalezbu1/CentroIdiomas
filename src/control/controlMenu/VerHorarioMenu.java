package control.controlMenu;

import java.awt.event.*;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.*;
import modelo.Usuarios.*;

public class VerHorarioMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("VerHorario")) {
			try {
				if(Main.user instanceof Estudiante) {
					String horario = ((Estudiante) Main.user).miHorario();
					Main.ventanaUsuario.ver(horario);
				}
				else if(Main.user instanceof Docente) {
					String horario = ((Docente) Main.user).miHorario();
					Main.ventanaUsuario.ver(horario);
				}
			} catch(NoHayHorario excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}