package control;

import java.util.Scanner;
import BaseDatos.Archivo;
import modelo.Usuarios.*;

/* La clase 'VerSolicitudes' es donde mostramos las solicitudes de cupo que ha realizado a un tipo de idioma un estudiante, si quien lo pregunta es de instancia 
 * diferente la instancia 'Estudiante'. Si por el contrario es un estudiante quien realiza la funcionalidad, se mostrara las solicitudes que él ha hecho.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerSolicitudes. */
public class VerSolicitudes extends OpcionDeMenu {
	private String nombre = "VerSolicitudes";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	/* Este metodo verfica que tipo de usuario esta realizando la opcion. Luego de ello procede a:
	 * si es estudiante, imprime las solicitudes que tiene por medio de el metodo 'verSolicitudes'
	 * si es de otro tipo de instancia, pide el documento del estudiante al cual quiere ver las solicitudes de cupo que hecho, comprueba que el estudiante este en 'Archivo'
	 * y de ser afirmativo, muestra las solicitudes de cupo si las tiene, sino notifica que no tiene solicitudes. 
	 * De caso contrario, avisa que no se encuentra ningun estudiante con ese ID. */
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		
		if (Main.user instanceof Estudiante) {
			String aux = ((Estudiante) Main.user).verSolicitudes();
			
			if (aux.equals("")) {
				System.out.println("\nUsted no tiene solicitudes.\n");
			} else {
				System.out.println("");
				System.out.println(aux+"\n");
			}
			
		} else {
			System.out.println("Introduzca el ID del estudiante del que quiere ver las solicitudes");
			long ID = entry.nextLong();
			Estudiante estudiante = Archivo.buscarEstudiante(ID);
			
			if(estudiante==null) {
				System.out.println("\nEl estudiante no esta registrado.\n");
			}else {
				String aux = estudiante.verSolicitudes();
				if(aux.equals("")){
					System.out.println("\nEl estudiante no tiene Solicitudes.\n");
				}else {
					System.out.println("");
					System.out.println(aux+"\n");
				}
			}
		}
		
	}
	/* Sobreescribimos el metodo de 'Object''toString'
	 * */
	public String toString() {
		return "Ver Solicitudes";
	}
}