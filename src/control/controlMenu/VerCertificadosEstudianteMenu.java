	package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import control.controlPanel.VerCertificadosEstudiantePanel;
/* La clase 'VerCertificados' es donde mostramos los certificados que tiene hasta el momento un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran los certificados que tiene el estudiante.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerCertificados. 
 */
public class VerCertificadosEstudianteMenu implements ActionListener{
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerCertificados")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerCertificadosEstudiantePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite ver los certificados de un estudiante ingresando su ID");
			Main.ventanaUsuario.getPanelP().nombre("Ver certificados de un estudiante");
			Main.ventanaUsuario.pack();
						
		}

	}
	
}
