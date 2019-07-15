package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

public class VerNotas extends OpcionDeMenu {
	private String nombre="VerNotas";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Estudiante quiere ver sus notas
		if(Main.user instanceof Estudiante) {
			for(Curso c : ((Estudiante) Main.user).getCurso()) {
				System.out.print(c.getNombreCurso() + ": " + ((Estudiante) Main.user).verNotas(c.getNombreCurso()) + "\n");
			}
		}
		//Usuario que no es Estudiante quiere ver las notas de un estudiante
		else {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Ingrese la cédula del estudiante del que quiere ver las notas: ");
			long ced = entrada.nextLong();
			for(Estudiante e : Archivo.getEstudiantes()) {
				if(e.getCedula()==ced) {
					for(Curso c : e.getCurso()) {
						System.out.print(c.getNombreCurso() + ": " + ((Estudiante) Main.user).verNotas(c.getNombreCurso()) + "\n");
					}
					break;
				}
			}
		}
	}

	public String toString() {
		return "Mis notas";
	}
}
