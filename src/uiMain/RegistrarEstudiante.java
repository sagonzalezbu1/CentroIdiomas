package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class RegistrarEstudiante extends OpcionDeMenu {
	public void ejecutar() {
		//Registra al estudiante con sus datos
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba su nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba su primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba su cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba su correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			Estudiante e = new Estudiante(nombre + " " + apellido, cc, correo, contraseña);
			System.out.println("\nSe ha registrado exitosamente.\n");
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa cédula.\n");
		}
	}
	
	public String toString() {
		return"Registrar Estudiante";
	}
}