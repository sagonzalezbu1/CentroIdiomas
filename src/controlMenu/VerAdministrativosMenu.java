package controlMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
/* La clase 'VerAdministrativos' es donde mostramos a los usuarios el nombre y la cedula todos los administrativos que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerAdministrativos.
 */
public class VerAdministrativosMenu implements ActionListener {
	
public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerAdministrativos")) {
			String adm= Archivo.verAdministrativos();
			Main.ventanaUsuario.ver(adm);
		}
		
	}

}
