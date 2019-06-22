package uiMain;

import java.util.Scanner;

import gestorAplicacion.usuarios.*;

import gestorAplicacion.Centro.*;

public class RegistrarAdministrativo extends OpcionDeMenu {
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
		System.out.println("Escriba la contraseņa que desee: ");
		String contraseņa = entrada.next();
		System.out.println("Esciba el codigo necesario para ser Administrativo: ");
		String codigo = entrada.next();
		if(codigo.equals(Administrativo.getCodigo())) {
			Administrativo a = new Administrativo(nombre + " " + apellido, cc, correo, contraseņa);
		}else {
			System.out.println("Codigo incorrecto");
		}
	}
	public String toString() {
		return"Registrar Administrativo";
	}
}