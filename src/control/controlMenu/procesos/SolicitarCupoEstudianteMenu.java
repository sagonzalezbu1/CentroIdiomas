package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.procesos.SolicitarCupoEstudiantePanel;
import control.controlPanel.procesos.SolicitarCupoPanel;
import defecto.Main;

/*Esta clase es usada por Estudiante para solicitar cupo a cursos que est�n llenos.
 * 
 * En esta clase se ejecuta el m�todo solicitar localizado en la clase Estudiante.*/

public class SolicitarCupoEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("SolicitarCupoEstudiante")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Cedula del Estudiante: ","Tipo del curso: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null};
			boolean[] habilitado = {true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new SolicitarCupoEstudiantePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite solicitar cupo para un estudiante a cursos no disponibles");
			Main.ventanaUsuario.getPanelP().nombre("Solicitar cupo para Estudiante");
			Main.ventanaUsuario.pack();			
		}
	}
}