package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Docente, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarDocente extends OpcionDeMenu {
	
	/*Se piden los datos necesarios y se ingresan en la creaci�n del objeto, con 
	 * algunas verificaciones de por medio*/
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba el nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba el primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba la cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba el correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contrase�a que desee: ");
		String contrase�a = entrada.next();
		System.out.println("Esciba el codigo necesario para ser docente: ");
		String codigo = entrada.next();
		//Verifica que el c�digo ingresado sea correcto
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			if (codigo.equals(Docente.getCodigo())) {
				Docente d = new Docente(nombre + " " + apellido, cc, correo, contrase�a);
				System.out.println("\nSe ha registrado exitosamente.\n");
			}
			else {
				System.out.println("\nCodigo incorrecto.\n");
			}
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa c�dula.\n");
		}
		
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Registrar Docente";
	}
}