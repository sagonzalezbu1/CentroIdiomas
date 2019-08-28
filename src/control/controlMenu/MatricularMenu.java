package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.MatricularEstudiantePanel;
import control.controlPanel.MatricularPanel;
import defecto.Main;

public class MatricularMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Matricular")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre del curso: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null};
			boolean[] habilitado = {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new MatricularPanel());
			Main.ventanaUsuario.getPanelP().descripcion("Matricula en un curso disponible");
			Main.ventanaUsuario.getPanelP().nombre("Matricular");
			Main.ventanaUsuario.pack();			
		}
		
	}

}
