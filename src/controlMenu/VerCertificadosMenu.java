package controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
/* La clase 'VerCertificados' es donde mostramos los certificados que tiene hasta el momento un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran los certificados que tiene el estudiante.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerCertificados. 
 */
public class VerCertificadosMenu implements ActionListener{
	private String nombre="VerCertificados";
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerCertificados")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
}
