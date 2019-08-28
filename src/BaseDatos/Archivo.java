package BaseDatos;

import java.util.*;

import javax.swing.JOptionPane;

import defecto.Main;
import modelo.Centro.Curso;
import modelo.Centro.Solicitud;
import modelo.Centro.Sugerencia;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/* La clase Archivo es donde guardamos todos los datos del Centro de Idiomas, lo que leen los metodos de la clase Data se guarda aquí y queda guardado en
 * varias estructuras de datos. Es una clase abstracta ya que no hay objetos de tipo archivo, es uno solo y es global para todo nuestro centro de idiomas
 * 
 * En esta clase estan implementados metodos de busqueda de usuarios, solicitudes y sugerencias, los cuales se utilizaran en las demas clases que lo necesiten.
 */
abstract public class Archivo {
	

	// El metodo add esta sobrecargado, el añadira a la lista correspondiente segun
	// el tipo de dato que reciba

	
	

	
	

	
	

	
	

	
	

	
	

	

	

	
	

	
	

	
	

	
	

	

	
	

	
	

	// Metodo que retorna la lista de administrativos, no recibe nada como parametro
	
	static public void verificarAdministrador(long cc, String pass) throws NoExisteAdministrador, LoginInvalido {
		if (Archivo.buscarAdministrador(cc).getContrasena().equals(pass)) {
			return;
		}
		throw new LoginInvalido();
	}

	/*static public void Calificar(String curso, long cedula) throws NoExisteCurso,NoHayEstudiantes {
			String respuesta = JOptionPane.showInputDialog(null, "Ingrese La nota del estudiante", "Calificacion",JOptionPane.INFORMATION_MESSAGE);
			x.calificar(curso, Float.parseFloat(respuesta));

		}
	}*/

	/*
	 * public void ejecutar() { Scanner entry = new Scanner(System.in);
	 * System.out.println("Introduzca el nombre del grupo al que desea calificar: "
	 * ); String cursocalificar = entry.next(); boolean existenciacurso = false;
	 * 
	 * for (Curso curso : Archivo.getCursos()) {
	 * 
	 * if (curso.getNombreCurso().equals(cursocalificar)) { existenciacurso = true;
	 * System.out.println("Introduzca la cedula del docente que da el curso: ");
	 * long ccdocente = entry.nextLong(); if (ccdocente ==
	 * curso.getDocente().getCedula()) {
	 * 
	 * if (curso.getEstudiantes().size() == 0) {
	 * System.out.println("\nEste curso no tiene estudiantes inscritos.\n"); } else
	 * {
	 * 
	 * for (Estudiante estudiante : curso.getEstudiantes()) { long id =
	 * estudiante.getCedula();
	 * System.out.println("Ingrese la nota del estudiante con ID " + id +
	 * " (si la nota es un float escribirla con coma): "); float calificacion =
	 * entry.nextFloat();
	 * 
	 * while(calificacion<0 || calificacion>5) {
	 * System.out.println("Ingrese una nota valida: "); calificacion =
	 * entry.nextFloat(); }
	 * 
	 * System.out.println(""); estudiante.calificar(cursocalificar, calificacion); }
	 * 
	 * System.out.println("Ya no quedan estudiantes por calificar.\n");
	 * 
	 * }
	 * 
	 * } else { System.out.println("\nLa cedula del docente no es correcta.\n"); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (existenciacurso == false) { System.out.println("\nEl curso '" +
	 * cursocalificar + "' no existe.\n"); } }
	 */

}
