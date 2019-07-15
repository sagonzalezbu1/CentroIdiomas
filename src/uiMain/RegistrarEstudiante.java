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
		System.out.println("Escriba la contraseņa que desee: ");
		String contraseņa = entrada.next();
		Estudiante e = new Estudiante(nombre + " " + apellido, cc, correo, contraseņa);
	}
	
	public String toString() {
		return"Registrar estudiante";
	}
}