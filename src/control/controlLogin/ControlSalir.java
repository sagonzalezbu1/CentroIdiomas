package control.controlLogin;
import java.awt.*;
import java.awt.event.*;

import BaseDatos.Data;
import defecto.Main;

public class ControlSalir implements MouseListener{
	public void mouseEntered(MouseEvent eento1) {
        if(Main.ventanaLogin.salir() == 0) {
        	Main.data.escribirDocentes();
        	Main.data.escribirEstudiantes();
        	Main.data.escribirAdministrativos();
        	Main.data.escribirSolicitudes();
        	Main.data.escribirCursos();
        	Main.data.escribirSugerencias();
			System.exit(0);
        }
    }
    public void mouseExited(MouseEvent evento2) {
    }
    public void mouseReleased(MouseEvent evento3) {
    }
    public void mouseClicked(MouseEvent evento3) {
    }
    public void mousePressed(MouseEvent evento3) {	
    }
    
}
	
	/*public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Salir")) {
			Data.escribirDocentes();
			Data.escribirEstudiantes();
			Data.escribirAdministrativos();
			Data.escribirSolicitudes();
			Data.escribirCursos();
			Data.escribirSugerencias();
			System.exit(0);
			
		}
	}*/
