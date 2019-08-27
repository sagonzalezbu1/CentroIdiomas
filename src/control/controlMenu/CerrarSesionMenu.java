package control.controlMenu;

import java.awt.event.ActionEvent;

import control.Main;
import control.OpcionDeMenu;
import modelo.Usuarios.*;
import vista.FieldPanel;
import vista.ventanaUsuario;

/*Esta clase es usada por todos los usuarios para volver al men� de Invitado*/
public class CerrarSesionMenu extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro*/
	public String getNombre() {
		return nombre;
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Salir")) {
			Main.ventanaUsuario.setVisible(false);;
			Main.ventanaLogin.setVisible(true);
			Main.ventanaUsuario = new ventanaUsuario();

		}
	}
	
	/*Se "convierte" al usuario registrado en un Invitado, ejecutando 
	 * el men� de este, creando el "efecto" de cerrar sesi�n*/
	public void ejecutar() {
		System.out.println("\nSe ha cerrado la sesi�n.\n");
		Main.user = new Invitado();
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Cerrar sesi�n";
	}
}