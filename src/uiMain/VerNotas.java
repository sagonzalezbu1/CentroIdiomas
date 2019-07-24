package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;
/* La clase 'VerNotas' es donde mostramos las notas que tiene hasta el momento y el acumulado de las mismas de un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran las notas que tiene el estudiante y el acumulado de las mismas.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerNotas. 
 */
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
					System.out.println("");
					for(Curso c : e.getCurso()) {
						System.out.print(c.getNombreCurso() + ": " + e.verNotas(c.getNombreCurso()) + "\n");
					}
					System.out.println("");
					return;
				}
			}
			System.out.println("\nEl estudiante no se encuentra.\n");
		}
	}

	public String toString() {
		return "Ver notas";
	}
}
