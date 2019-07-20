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
		if(Archivo.buscarEstudiante(cc) == null) {
			Estudiante e = new Estudiante(nombre + " " + apellido, cc, correo, contraseña);
		}
		else {
			System.out.println("Ya se encuentra registrado un estudiante con esa cédula");
		}
	}
	
	public String toString() {
		return"Registrar Estudiante";
	}
}