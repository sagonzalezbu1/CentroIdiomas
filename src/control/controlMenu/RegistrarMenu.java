package control.controlMenu;
import control.*;
import control.OpcionDeMenu;

/*Esta clase es usada por Invitado para crear una cuenta de otro tipo, ya sea Administrativo,
 * Estudiante o Docente.*/
public class RegistrarMenu extends OpcionDeMenu {
	private String nombre="Registrar";
	//Se crea un submenú para saber qué tipo de usuario se registrará
	MenuDeConsola menu = new MenuDeConsola(new RegistrarEstudianteMenu(),new RegistrarDocenteMenu(),new RegistrarAdministrativoMenu());
	
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}

	//Se ejecuta el submenú
	public void ejecutar() {
		menu.lanzarMenu();
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Registrar";
	}
	
}