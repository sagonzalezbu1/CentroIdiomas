package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

public class SolicitarCupo extends OpcionDeMenu{
	private String nombre="SolicitarCupo";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		//Se verifica qué tipo de usuario hace la solicitud
		if(Main.user instanceof Estudiante) {
			//Si es estudiante le hace la solicitud normal
			System.out.println("Ingrese la materia a la cual va a solicitar el cupo: ");
			String aux = entry.next();
			((Estudiante)Main.user).solicitar(aux);
			return;
		}
		else {
			//Si es otro, pregunta a qué estudiante se le va a solicitar
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long aux1 = entry.nextLong();
			System.out.println("Ingrese la materia a la cual va a solicitar el cupo: ");
			String aux2 = entry.next();
			for(Estudiante x : Archivo.getEstudiantes()) {
				if(x.getCedula()==aux1) {
					x.solicitar(aux2);
					return;
				}
			}
		}
		System.out.println("Estudiante no encontrado");
	}
	public String toString(){
		return "Solicitar Cupo";
	}
}