package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import control.controlPanel.SolicitarCupoEstudiantePanel;
import control.controlPanel.SolicitarCupoPanel;

/*Esta clase es usada por Estudiante para solicitar cupo a cursos que estén llenos.
 * 
 * En esta clase se ejecuta el método solicitar localizado en la clase Estudiante.*/

public class SolicitarCupoEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("SolicitarCupoEstudiante")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Cedula del Estudiante: ","Tipo del curso: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null};
			boolean[] habilitado = {true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new SolicitarCupoEstudiantePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite solicitar cupo para un estudiante a cursos no disponibles");
			Main.ventanaUsuario.getPanelP().nombre("Solicitar cupo para Estudiante");
			Main.ventanaUsuario.pack();
			
		}
	}
}