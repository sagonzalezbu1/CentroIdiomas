package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import control.controlPanel.VerHorarioEstudiantePanel;

public class VerHorarioEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getActionCommand().equals("VerHorarioDocente")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerHorarioEstudiantePanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver horario del estudiante");
			Main.ventanaUsuario.getPanelP().descripcion("Aqui podra ver el horario del docente del cual coloque su cedula. Recuerde no poner puntos ni espacios.");
		}
		
	}

}