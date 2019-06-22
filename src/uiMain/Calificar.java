package uiMain;
import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.usuarios.*;

import gestorAplicacion.Centro.Archivo;
public class Calificar extends OpcionDeMenu {
	public void ejecutar() {
		Scanner entry =new Scanner(System.in);
		System.out.println("Introduzca el nombre del grupo al que desea calificar: ");
		String aux = entry.next();
		for(Curso x: Archivo.getCursos()) {
			if (x.getNombreCurso().equals(aux)) {
				for(Estudiante y:x.getEstudiantes()) {
					long aux2 = y.getCedula();
					System.out.println("Ingrese la nota del estudiante con ID " + aux2 );
					float aux3 = entry.nextFloat();
					y.calificar(aux,aux3);
				}
			}
			else {
				System.out.println("El curso no existe");
			}
		}
		
	}
	public String toString() {
		return "Calificar Estudiantes";
	}

}