package control;
import java.awt.*;
import java.awt.event.*;

import BaseDatos.Data;

public class ControlSalir implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Salir")) {
			Data.escribirDocentes();
			Data.escribirEstudiantes();
			Data.escribirAdministrativos();
			Data.escribirSolicitudes();
			Data.escribirCursos();
			Data.escribirSugerencias();
			System.exit(0);
			
		}
	}
}