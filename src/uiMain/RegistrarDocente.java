package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class RegistrarDocente extends OpcionDeMenu {
	public void ejecutar() {
		//Registra al docente con sus datos
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
		//Verifica que el c�digo sea correcto
		if(Archivo.buscarDocente(cc).getCedula() != cc) {
			if (codigo.equals(Docente.getCodigo())) {
				Docente d = new Docente(nombre + " " + apellido, cc, correo, contrase�a);
			}
			else {
				System.out.println("Codigo incorrecto");
			}
		}
		else {
			System.out.println("Ya se encuentra registrado un Docente con esa c�dula");
		}
		
	}

	public String toString() {
		return "Registrar Docente";
	}
}