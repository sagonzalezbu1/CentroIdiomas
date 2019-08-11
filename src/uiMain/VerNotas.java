package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;
import BaseDatos.Archivo;

/* La clase 'VerNotas' es donde mostramos las notas que tiene hasta el momento y el acumulado de las mismas de un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran las notas que tiene el estudiante y el acumulado de las mismas.
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerNotas. */
public class VerNotas extends OpcionDeMenu {
	private String nombre="VerNotas";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro. */
	public String getNombre() {
		return nombre;
	}
	
	/* Este metodo verfica que tipo de usuario esta realizando la opcion. Luego de ello procede a:
	 * si es estudiante, imprime las notas que tiene por medio de el metodo 'verNotas'
	 * si es de otro tipo de instancia, pide el documento del estudiante al cual quiere ver las notas que tiene, comprueba que el estudiante este en 'Archivo'
	 * y de ser afirmativo, notifica las notas. De caso contrario, avisa que no se encuentra ningun estudiante con ese ID.*/
	public void ejecutar() {
		
		if(Main.user instanceof Estudiante) {
			for(Curso curso : ((Estudiante) Main.user).getCurso()) {
				System.out.print(curso.getNombreCurso() + ": " + ((Estudiante) Main.user).verNotas(curso.getNombreCurso()) + "\n");
			}
		}
		else {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Ingrese la c�dula del estudiante del que quiere ver las notas: ");
			long cedula = entrada.nextLong();
			
			for(Estudiante estudiante : Archivo.getEstudiantes()) {
				
				if(estudiante.getCedula()==cedula) {
					System.out.println("");
					for(Curso curso : estudiante.getCurso()) {
						System.out.print(curso.getNombreCurso() + ": " + estudiante.verNotas(curso.getNombreCurso()) + "\n");
					}
					System.out.println("");
					return;
				}
				
			}
			
			System.out.println("\nEl estudiante no se encuentra.\n");
			
		}
	}
	
	/* Sobreescribimos el metodo de 'Object''toString'. */
	public String toString() {
		return "Ver notas";
	}
}
