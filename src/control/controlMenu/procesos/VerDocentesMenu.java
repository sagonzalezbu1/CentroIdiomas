package control.controlMenu.procesos;

import java.awt.event.*;
import defecto.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;
import modelo.excepciones.modelo.NoHayDocentes;

/* La clase 'VerDocentes' es donde mostramos a los usuarios el nombre y la cedula todos los docentes que se encuentren en 'Archivo'. 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerDocentes.
 */
public class VerDocentesMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerDocentes")) {
			try {
				String docentes = Docente.verDocentes();
				Main.ventanaUsuario.ver(docentes);
				Main.ventanaUsuario.getPanelP().nombre("Ver docentes");
				Main.ventanaUsuario.getPanelP()
						.descripcion("Imprime el nombre y la cedula los docentes que estan registrados en el curso");
				Main.ventanaUsuario.pack();
			} catch (NoHayDocentes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}