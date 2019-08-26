package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;

/* La clase 'VerSolicitudes' es donde mostramos las solicitudes de cupo que ha realizado a un tipo de idioma un estudiante, si quien lo pregunta es de instancia 
 * diferente la instancia 'Estudiante'. Si por el contrario es un estudiante quien realiza la funcionalidad, se mostrara las solicitudes que él ha hecho.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSolicitudes. */
public class VerSolicitudesMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerSolicitudes")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);

		}

	}

}