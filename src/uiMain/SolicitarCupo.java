package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

import BaseDatos.Archivo;

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
			String aux = entry.next();
			for(Curso x:((Estudiante)Main.user).getCurso()) {
				if(x.getTipo().equals(aux)) {
					System.out.println("Usted esta viendo un curso de este tipo, no puede solicitar.\n");
					return;
				}
			}
			for(Solicitud x: ((Estudiante)Main.user).getSolicitudes()) {
				if(x.getTipo().equals(aux)) {
					System.out.println("Usted ya hizo una solicitud para este tipo, no puede solicitar.\n");
					return;
				}
			}
			for(Certificado x: ((Estudiante)Main.user).getCertificados()) {
				if(x.getNombre().equals(aux)) {
					System.out.println("Usted ya aprobo una materia para este tipo, no puede solicitar.\n");
					return;
				}
			}
			if (Archivo.cursoDisponibilidad(aux) == null) {
				((Estudiante) Main.user).solicitar(aux);
				System.out.println("\nSu solicitud ha sido exitosa.\n");
				return;
			} else {
				System.out.println("Hay cupos disponibles, no puede solicitar.\n");
			}

		} else {
			System.out.println("Ingrese el ID del estudiante al que va a solicitarle cupo: ");
			long aux1 = entry.nextLong();
			Estudiante x= Archivo.buscarEstudiante(aux1);
			if (x != null) {
				System.out.println("Ingrese el tipo de la materia a la cual va a solicitar el cupo: ");
				String aux = entry.next();
				for(Curso y: x.getCurso()) {
					if(y.getTipo().equals(aux)) {
						System.out.println("Usted esta viendo un curso de este tipo, no puede solicitar.\n");
						return;
					}
				}
				for(Solicitud y: x.getSolicitudes()) {
					if(y.getTipo().equals(aux)) {
						System.out.println("Usted ya hizo una solicitud para este tipo, no puede solicitar.\n");
						return;
					}
				}
				for(Certificado y: x.getCertificados()) {
					if(y.getNombre().equals(aux)) {
						System.out.println("Usted ya aprobo una materia para este tipo, no puede solicitar.\n");
						return;
					}
				}
				if (Archivo.cursoDisponibilidad(aux) == null) {
					x.solicitar(aux);
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