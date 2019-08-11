package uiMain;
import BaseDatos.Archivo;
/* La clase 'VerCursos' es donde mostramos a los usuarios el nombre, el horario, el docente y la disponibilidad de cupos con los que cuenta los cursos  que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerCursos.
 */
public class VerCursos extends OpcionDeMenu {
	private String nombre="VerCursos";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	// En este metodo mostramos los curso si los hay; sino informamos de ello al usuario. Este metodo no recibe ningun parametro.
	public void ejecutar() {
		System.out.println(Archivo.verCursos());
	}
	
	/* Sobreescribimos el metodo de 'Object''toString'.*/
	public String toString() {
		return "Ver cursos";
	}
}