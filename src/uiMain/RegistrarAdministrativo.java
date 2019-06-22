package uiMain;

import java.util.Scanner;

import gestorAplicacion.usuarios.*;

import gestorAplicacion.Centro.*;

public class RegistrarAdministrativo extends OpcionDeMenu {
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
		System.out.println("Esciba el codigo necesario para ser Administrativo: ");
		String codigo = entrada.next();
		if(codigo.equals(Administrativo.getCodigo())) {
			Administrativo a = new Administrativo(nombre + " " + apellido, cc, correo, contraseña);
			a.getMenu().lanzarMenu();
			int eleccion = entrada.nextInt();
			a.getMenu().ejecutarOpcion(eleccion);
		}else {
			Invitado.getMenu().lanzarMenu();
			int eleccion = entrada.nextInt();
			Invitado.getMenu().ejecutarOpcion(eleccion);
		}
	}
	public String toString() {
		return"Registrar Administrativo";
	}
}