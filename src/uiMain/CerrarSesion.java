package uiMain;

import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por todos los usuarios para volver al men� de Invitado*/
public class CerrarSesion extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro*/
	public String getNombre() {
		return nombre;
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