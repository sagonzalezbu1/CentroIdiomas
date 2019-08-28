package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.procesos.VerHorarioEstudiantePanel;
import defecto.Main;

public class VerHorarioEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getActionCommand().equals("VerHorarioEstudiante")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerHorarioEstudiantePanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver horario del estudiante");
			Main.ventanaUsuario.getPanelP().descripcion("Aqui podra ver el horario del Estudiante del cual coloque su cedula");
			Main.ventanaUsuario.pack();
		}
		
	}

}
