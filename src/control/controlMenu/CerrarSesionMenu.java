package control.controlMenu;

import java.awt.event.ActionEvent;

import control.Main;
import control.OpcionDeMenu;
import modelo.Usuarios.*;
import vista.FieldPanel;
import vista.ventanaUsuario;

/*Esta clase es usada por todos los usuarios para volver al menú de Invitado*/
public class CerrarSesionMenu extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
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
	 * el menú de este, creando el "efecto" de cerrar sesión*/
	public void ejecutar() {
		System.out.println("\nSe ha cerrado la sesión.\n");
		Main.user = new Invitado();
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Cerrar sesión";
	}
}