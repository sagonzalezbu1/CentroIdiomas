package controlMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
/* La clase 'VerDocentes' es donde mostramos a los usuarios el nombre y la cedula todos los docentes que se encuentren en 'Archivo'. 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerDocentes.
 */
public class VerDocentesMenu implements ActionListener{
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerDocentes")) {
			String docentes= Archivo.verDocentes();
			Main.ventanaUsuario.ver(docentes);
		}
		
	}
	
}
