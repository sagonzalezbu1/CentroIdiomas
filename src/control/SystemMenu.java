package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BaseDatos.Archivo;


/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles del sistema.
 * 
 * En esta clase se ejecuta el método SystemMenu localizado en la clase Administrador*/
public class SystemMenu implements ActionListener {
	
	//Se muestran todas las funcionalidades del sistema
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("SystemMenu")) {
			String Funciones= Archivo.getAdministrador().SystemMenu();
			Main.ventanaUsuario.ver(Funciones);
		}

	}
	
}