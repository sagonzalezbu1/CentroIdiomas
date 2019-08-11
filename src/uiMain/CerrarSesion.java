package uiMain;

import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por todos los usuarios para volver al menú de Invitado*/
public class CerrarSesion extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
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