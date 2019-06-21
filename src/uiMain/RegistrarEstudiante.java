package uiMain;

import java.util.Scanner;

import gestorAplicacion.usuarios.*;

import gestorAplicacion.Centro.*;

public class RegistrarEstudiante extends OpcionDeMenu {
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
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		Estudiante e = new Estudiante(nombre + " " + apellido, cc, correo, contraseña);
		Archivo.add(e);
	}
	public String toString() {
		return"Registrar estudiante";
	}
}