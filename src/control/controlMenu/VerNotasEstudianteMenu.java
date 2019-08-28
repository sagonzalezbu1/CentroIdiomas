package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.VerNotasEstudiantePanel;
import defecto.Main;

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
			Main.ventanaUsuario.getPanelP().setControlador(new VerNotasEstudiantePanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver notas de un estudiante");
			Main.ventanaUsuario.getPanelP().descripcion("Recibe la cedula de un estudiante y luego muestra las notas que tiene este\nestudiante");
			Main.ventanaUsuario.pack();
		}

	}
}
