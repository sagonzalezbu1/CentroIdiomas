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
		System.out.println("Escriba la contrase�a que desee: ");
		String contrase�a = entrada.next();
		System.out.println("Esciba el codigo necesario para ser Administrativo: ");
		String codigo = entrada.next();
		//Verifica que el c�digo sea correcto
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			if(codigo.equals(Administrativo.getCodigo())) {
				Administrativo a = new Administrativo(nombre + " " + apellido, cc, correo, contrase�a);
				System.out.println("\nSe ha registrado exitosamente.\n");
			}else {
				System.out.println("\nCodigo incorrecto.\n");
			}
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa c�dula.\n");
		}

	}
	public String toString() {
		return"Registrar Administrativo";
	}
}