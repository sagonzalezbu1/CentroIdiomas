package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.procesos.VerSolicitudesEstudiantePanel;
import defecto.Main;

/* La clase 'VerSolicitudes' es donde mostramos las solicitudes de cupo que ha realizado a un tipo de idioma un estudiante, si quien lo pregunta es de instancia 
 * diferente la instancia 'Estudiante'. Si por el contrario es un estudiante quien realiza la funcionalidad, se mostrara las solicitudes que �l ha hecho.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSolicitudes. */
public class VerSolicitudesEstudianteMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerSolicitudesEstudiante")) {
			String tituloCriterios = "Criterio";
			String tituloValores = "Valor";
			String[] criterios = { "Cedula del estudiante: " };
			String[] valores = { "" };
			boolean[] habilitado = { true };
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerSolicitudesEstudiantePanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver solicitudes de un estudiante");
			Main.ventanaUsuario.getPanelP().descripcion(
					"Recibe la cedula de un estudiante y luego muestra las solicitudes que ha hecho este estudiante");
			Main.ventanaUsuario.pack();
		}

	}

}