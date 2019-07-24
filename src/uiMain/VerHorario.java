package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;
/* La clase 'VerHorario' es donde mostramos el horario que tiene hasta en el momento un estudiante o un docente, si quien lo realiza es de instancia 
 * diferente la instancia 'Estudiante' o 'Docente'. Por el contrario se mostraran wl horario con el que cuenta.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' o 'Docente' VerHorario. 
 */
public class VerHorario extends OpcionDeMenu {
	private String nombre="VerHorario";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Verifica qué tipo de usuario verá el horario
		if (Main.user instanceof Estudiante) {
			//Si es estudiante le mostrará su horario
			System.out.println("");
			System.out.println(((Estudiante) Main.user).miHorario());
		}
		else if (Main.user instanceof Docente) {
			//Si es docente le mostrará su horario
			System.out.println(((Docente) Main.user).miHorario());
		}
		else {
			//Si es administrativo o adminsitrador preguntará de quién ver el horario
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese la cedula de quien quiere ver el horario: ");
			long ID = entry.nextLong();
			//Busca el usuario y muestra el respectivo horario
			for (Docente x : Archivo.getDocentes()) {
				if (x.getCedula() == ID) {
					System.out.println(x.miHorario());
					return;
				}
			}
			for (Estudiante y : Archivo.getEstudiantes()) {
				if (y.getCedula() == ID) {
					System.out.println("");
					System.out.println(y.miHorario());
					return;
				}
			}
			System.out.println("\nNo se ha encontrado ningun usuario.\n");
		}
	}

	public String toString() {
		return "Ver horario";
	}
}