package control.controlMenu.procesos;

import java.awt.event.*;
import defecto.*;
import modelo.Centro.*;
import modelo.excepciones.*;
import modelo.excepciones.modelo.NoHaySugerencias;

/* La clase 'VerSugerencias' es donde mostramos a los usuarios el nombre de quien realizo una sugerencia seguido de la sugerencia
 * que realizo. Esto para cada una de las sugerencias localizadas en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSugerencias. */

public class VerSugerenciasMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerSugerencias")) {
			try {
				String sugerencia = Sugerencia.verSugerencias();
				Main.ventanaUsuario.ver(sugerencia);
				Main.ventanaUsuario.pack();
			} catch (NoHaySugerencias excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}