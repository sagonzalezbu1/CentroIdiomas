package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class RegistrarDocente extends OpcionDeMenu {
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba la nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba la primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba la cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba el correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contraseņa que desee: ");
		String contraseņa = entrada.next();
		System.out.println("Esciba el codigo necesario para ser docente: ");
		String codigo = entrada.next();
		if (codigo.equals(Docente.getCodigo())) {
			Docente d = new Docente(nombre + " " + apellido, cc, correo, contraseņa);
		}
		else {
			System.out.println("Codigo incorrecto");
		}

	}

	public String toString() {
		return "Registrar Docente";
	}
}