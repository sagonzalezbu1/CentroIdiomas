package control.controlMenu;
import control.*;
import control.OpcionDeMenu;

/*Esta clase es usada por Invitado para crear una cuenta de otro tipo, ya sea Administrativo,
 * Estudiante o Docente.*/
public class RegistrarMenu extends OpcionDeMenu {
	
	
	
	/*private String nombre="Registrar";
	//Se crea un submen� para saber qu� tipo de usuario se registrar�
	MenuDeConsola menu = new MenuDeConsola(new RegistrarEstudianteMenu(),new RegistrarDocenteMenu(),new RegistrarAdministrativoMenu());
	
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro
	public String getNombre() {
		return nombre;
	}

	//Se ejecuta el submen�
	public void ejecutar() {
		menu.lanzarMenu();
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�
	public String toString() {
		return "Registrar";
	}*/	
}