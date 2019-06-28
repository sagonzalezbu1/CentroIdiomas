package uiMain;

import java.util.Scanner;

import gestorAplicacion.Centro.Solicitud;

public class RechazarSolicitud extends OpcionDeMenu{
	private static Scanner e= new Scanner(System.in);
	public void ejecutar() {
		System.out.println(Solicitud.solicitudes());
		System.out.println("Ingrese el tipo de la materia que desea rechazar solicitudes: ");
		String tipo= e.next();
		Solicitud s= new Solicitud(tipo);
		s.rechazarSolicitud();
	}
	public static int CC(String cc){
		System.out.println(cc);
		System.out.println("Ingrese al el numero de la posicion del estudiante que desea rechazar la solicitud: ");
		int x= e.nextInt();
		return x;
	}
	public String toString() {
		return "Rechazar solicitud";
	}
}
