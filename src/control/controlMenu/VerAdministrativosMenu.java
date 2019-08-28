package control.controlMenu;

import java.awt.event.*;
import control.controlPanel.*;
import defecto.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/* La clase 'VerAdministrativos' es donde mostramos a los usuarios el nombre y la cedula todos los administrativos que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerAdministrativos.
 */
public class VerAdministrativosMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("VerAdministrativos")) {
			try {
				String Administrativos = Administrativo.verAdministrativos();
				Main.ventanaUsuario.ver(Administrativos);
				Main.ventanaUsuario.getPanelP().nombre("Ver todos los Administrativos");
				Main.ventanaUsuario.getPanelP().descripcion("Permite ver todos los administrativos del CDI");
				Main.ventanaUsuario.pack();
			} catch (NoHayAdministrativos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}

		}

	}

}
