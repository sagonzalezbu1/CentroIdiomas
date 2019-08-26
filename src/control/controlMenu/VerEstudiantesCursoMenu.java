package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.Main;
import control.controlPanel.VerEstudiantesCursoPanel;

/* La clase 'VerEstudiantesCurso' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes registrados el curso que ha elegido para ver los estudiantes.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerEstudiantesCurso.*/
public class VerEstudiantesCursoMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerEstudiantesCurso")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Nombre del curso: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerEstudiantesCursoPanel());
		}

	}
	
}
