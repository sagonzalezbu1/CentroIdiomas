package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import BaseDatos.Archivo;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Estudiante para solicitar cupo a cursos que estén llenos.
 * 
 * En esta clase se ejecuta el método solicitar localizado en la clase Estudiante.*/

public class SolicitarCupo implements ActionListener {
	
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