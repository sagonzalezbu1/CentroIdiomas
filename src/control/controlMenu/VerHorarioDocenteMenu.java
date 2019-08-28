package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import control.controlPanel.VerHorarioDocentePanel;

/* La clase 'VerHorario' es donde mostramos el horario que tiene hasta en el momento un estudiante o un docente, si quien lo realiza es de instancia 
 * diferente la instancia 'Estudiante' o 'Docente'. Por el contrario se mostraran wl horario con el que cuenta.
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' o 'Docente' VerHorario.*/
public class VerHorarioDocenteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerHorarioDocente")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del docente: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerHorarioDocentePanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver horario del docente");
			Main.ventanaUsuario.getPanelP().descripcion("Recibe la cedula de un usuario y luego muestra el menu que este tiene");
			Main.ventanaUsuario.pack();
		}

	}
	
}