package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Calificar extends OpcionDeMenu {
	private String nombre="Calificar";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se califica buscando primero el grupo y luego el estudiante
		Scanner entry =new Scanner(System.in);
		System.out.println("Introduzca el nombre del grupo al que desea calificar: ");
		String aux = entry.next();
		boolean bool = false;
		
		for(Curso x: Archivo.getCursos()) {
			if (x.getNombreCurso().equals(aux)) {
				bool = true;
				System.out.println("Introduzca la cedula del docente que da el curso");
				long aux4 = entry.nextLong();
				if(aux4 == x.getDocente().getCedula()) {
					for(Estudiante y:x.getEstudiantes()) {
						long aux2 = y.getCedula();
						System.out.println("Ingrese la nota del estudiante con ID " + aux2 );
						float aux3 = entry.nextFloat();
						System.out.println("");
						y.calificar(aux,aux3);
					}
				}
				else {
					System.out.println("La cedula del docente no es correcta");
				}
				
			}
			
		}
		if (bool == false) {
			System.out.println("El curso no existe");
		}
		
	}
	public String toString() {
		return "Calificar Estudiantes";
	}

}