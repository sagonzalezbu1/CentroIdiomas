package controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;

/* La clase 'VerNotas' es donde mostramos las notas que tiene hasta el momento y el acumulado de las mismas de un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran las notas que tiene el estudiante y el acumulado de las mismas.
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerNotas. */
public class VerNotasEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerNotasEstudiante")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
}
