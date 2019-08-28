package control.controlMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.NoHayDocentes;
/* La clase 'VerDocentes' es donde mostramos a los usuarios el nombre y la cedula todos los docentes que se encuentren en 'Archivo'. 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerDocentes.
 */
public class VerDocentesMenu implements ActionListener{
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerDocentes")) {
			try{
				String docentes= Archivo.verDocentes();
				Main .ventanaUsuario.ver(docentes);
				Main.ventanaUsuario.getPanelP().nombre("Ver docentes");
				Main.ventanaUsuario.getPanelP().descripcion("Imprime el nombre y la cedula los docentes que estan registrados en el curso");
				Main.ventanaUsuario.pack();
			}catch(NoHayDocentes excepcion){
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
		
	}
	
}
