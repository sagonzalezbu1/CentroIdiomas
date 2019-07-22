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
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		System.out.println("Esciba el codigo necesario para ser docente: ");
		String codigo = entrada.next();
		//Verifica que el código sea correcto
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			if (codigo.equals(Docente.getCodigo())) {
				Docente d = new Docente(nombre + " " + apellido, cc, correo, contraseña);
				System.out.println("\nSe ha registrado exitosamente.\n");
			}
			else {
				System.out.println("\nCodigo incorrecto.\n");
			}
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa cédula.\n");
		}
		
	}

	public String toString() {
		return "Registrar Docente";
	}
}