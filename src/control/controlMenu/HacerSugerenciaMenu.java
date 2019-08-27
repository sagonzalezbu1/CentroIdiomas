package control.controlMenu;

import java.awt.event.*;
import control.*;
import control.controlPanel.*;

/*Esta clase es usada por Docente y Estudiante para realizar sugerencias sobre 
 * el programa y su funcionamiento.
 * 
 * En esta clase se crean objetos de tipo Sugerencia y se 
 * les asignan sus respectivos atributos.*/
public class HacerSugerenciaMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("HacerSugerencia")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Escriba la sugerencia: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new HacerSugerenciaPanel());
			Main.ventanaUsuario.getPanelP().nombre("Hacer una sugerencia");
			Main.ventanaUsuario.getPanelP().descripcion("Permite escribir una sugerencia acerca del funcionamiento del programa.");
			Main.ventanaUsuario.pack();
		}
	}
}