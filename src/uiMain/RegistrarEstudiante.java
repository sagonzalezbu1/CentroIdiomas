package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Estudiante, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarEstudiante extends OpcionDeMenu {
	
	/*Se piden los datos necesarios y se ingresan en la creaci�n del objeto, con 
	 * algunas verificaciones de por medio*/
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba su nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba su primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba su cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba su correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contrase�a que desee: ");
		String contrase�a = entrada.next();
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			Estudiante e = new Estudiante(nombre + " " + apellido, cc, correo, contrase�a);
			System.out.println("\nSe ha registrado exitosamente.\n");
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa c�dula.\n");
		}
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return"Registrar Estudiante";
	}
}