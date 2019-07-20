package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class RegistrarAdministrativo extends OpcionDeMenu {
	//Registra al administrativo con sus datos
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
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		System.out.println("Esciba el codigo necesario para ser Administrativo: ");
		String codigo = entrada.next();
		//Verifica que el código sea correcto
		if(Archivo.buscarAdministrativo(cc) == null) {
			if(codigo.equals(Administrativo.getCodigo())) {
				Administrativo a = new Administrativo(nombre + " " + apellido, cc, correo, contraseña);
			}else {
				System.out.println("Codigo incorrecto");
			}
		}
		else {
			System.out.println("Ya se encuentra registrado un Administrativo con esa cédula");
		}

	}
	public String toString() {
		return"Registrar Administrativo";
	}
}