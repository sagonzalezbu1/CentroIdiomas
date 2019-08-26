package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BaseDatos.Archivo;

/* La clase 'VerSugerencias' es donde mostramos a los usuarios el nombre de quien realizo una sugerencia seguido de la sugerencia
 * que realizo. Esto para cada una de las sugerencias localizadas en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSugerencias. */
public class VerSugerencias implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerSugerencias")) {
			String sugerencia = Archivo.verSugerencias();
			Main.ventanaUsuario.ver(sugerencia);
		}

	}

}
