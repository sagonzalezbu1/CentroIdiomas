package control;

import java.util.*;

import BaseDatos.Archivo;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Estudiante para solicitar cupo a cursos que estén llenos.
 * 
 * En esta clase se ejecuta el método solicitar localizado en la clase Estudiante.*/

public class SolicitarCupo extends OpcionDeMenu {
	private String nombre = "SolicitarCupo";

	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		
		/*Se hacen verificaciones para el buen funcionamiento antes de hacer la solicitud,
		 * como duplicados en solicitudes, solicitudes a cursos ya cursados o que actualmente
		 * se están cursando, entre las básicas*/
		Scanner entry = new Scanner(System.in);
		//Se pregunta qué tipo de usuario hace la solicitud
		if (Main.user instanceof Estudiante) {
			System.out.println("Ingrese el tipo de la materia a la cual va a solicitar el cupo: ");
			String tipo = entry.next();
			
			for(Curso curso:((Estudiante)Main.user).getCurso()) {
				if(curso.getTipo().equals(tipo)) {
					System.out.println("Usted esta viendo un curso de este tipo, no puede solicitar.\n");
					return;
				}
			}
			
			for(Solicitud solicitud: ((Estudiante)Main.user).getSolicitudes()) {
				if(solicitud.getTipo().equals(tipo)) {
					System.out.println("Usted ya hizo una solicitud para este tipo, no puede solicitar.\n");
					return;
				}
			}
			
			for(Certificado certificado: ((Estudiante)Main.user).getCertificados()) {
				if(certificado.getNombre().equals(tipo)) {
					System.out.println("Usted ya aprobo una materia para este tipo, no puede solicitar.\n");
					return;
				}
			}
			
			if (Archivo.cursoDisponibilidad(tipo) == null) {
				((Estudiante) Main.user).solicitar(tipo);
				System.out.println("\nSu solicitud ha sido exitosa.\n");
				return;
			} else {
				System.out.println("Hay cupos disponibles, no puede solicitar.\n");
			}

		} else {
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long idestu = entry.nextLong();
			Estudiante estudiante= Archivo.buscarEstudiante(idestu);
			
			if (estudiante != null) {
				System.out.println("Ingrese el tipo de la materia a la cual va a solicitar el cupo: ");
				String tipo = entry.next();
				
				for(Curso y: estudiante.getCurso()) {
					if(y.getTipo().equals(tipo)) {
						System.out.println("Usted esta viendo un curso de este tipo, no puede solicitar.\n");
						return;
					}
				}
				
				for(Solicitud y: estudiante.getSolicitudes()) {
					if(y.getTipo().equals(tipo)) {
						System.out.println("Usted ya hizo una solicitud para este tipo, no puede solicitar.\n");
						return;
					}
				}
				
				for(Certificado y: estudiante.getCertificados()) {
					if(y.getNombre().equals(tipo)) {
						System.out.println("Usted ya aprobo una materia para este tipo, no puede solicitar.\n");
						return;
					}
				}
				
				if (Archivo.cursoDisponibilidad(tipo) == null) {
					estudiante.solicitar(tipo);
					System.out.println("Su solicitud ha sido exitosa.\n");
					return;
				} else {
					System.out.println("Hay cupos disponibles, no puede solicitar.\n");
				}
				
			}else {
				System.out.println("Estudiante no encontrado.\n");
			}
			
		}
		
	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Solicitar Cupo";
	}
}