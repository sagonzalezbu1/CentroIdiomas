package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;

/*Esta clase es usada por Estudiante para solicitar cupo a cursos que est�n llenos.
 * 
 * En esta clase se ejecuta el m�todo solicitar localizado en la clase Estudiante.*/

public class SolicitarCupoMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("SolicitarCupo")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Cedula del Estudiante:","Tipo del curso:"};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null};
			boolean[] habilitado = {true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
		}

	}
}