package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.DocenteIncorrecto;
import modelo.excepciones.NoExisteCurso;
import modelo.excepciones.NoHayEstudiantes;

public class CalificarPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String curso = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso al que desea Calificar: ");		
				long cedula = Long.parseLong(Main.ventanaUsuario.getPanelP().getValue("Cedula del docente que da el curso: "));	
				Archivo.PreCalificar(curso, cedula);
				for(Estudiante x : (ArrayList<Estudiante>)Archivo.buscarCurso(curso).getEstudiantes()) {
					String respuesta = JOptionPane.showInputDialog(null, "Ingrese La nota del estudiante" + x.getCedula(), "Calificacion",JOptionPane.INFORMATION_MESSAGE);
					x.calificar(curso, Float.parseFloat(respuesta));
				}	
			}
			catch(CampoVacio exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
			catch(NoExisteCurso exception2) {
				Main.ventanaUsuario.Popup(exception2.getMessage());
			}
			catch(DocenteIncorrecto exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
			catch(NoHayEstudiantes exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
		}
		else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
