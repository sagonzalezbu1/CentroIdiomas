package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.excepciones.modelo.NoExisteAdministrador;


/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles del sistema.
 * 
 * En esta clase se ejecuta el m�todo SystemMenu localizado en la clase Administrador*/
public class SystemMenu implements ActionListener {
	
	//Se muestran todas las funcionalidades del sistema
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("SystemMenu")) {
				String Funciones= (new Administrador()).SystemMenu();
				Main.ventanaUsuario.ver(Funciones);
				Main.ventanaUsuario.getPanelP().nombre("Ver funcionalidades del sistema");
				Main.ventanaUsuario.getPanelP().descripcion("Imprime las funcionalidades que tenemos en el sistema.");
				Main.ventanaUsuario.pack();
		}

	}
	
}