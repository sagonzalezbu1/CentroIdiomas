package uiMain;
import gestorAplicacion.Centro.Archivo;
/* La clase 'VerCursos' es donde mostramos a los usuarios el nombre, el horario, el docente y la disponibilidad de cupos con los que cuenta los cursos  que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerCursos.
 */
public class VerCursos extends OpcionDeMenu {
	private String nombre="VerCursos";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Muestra por pantalla los cursos con su información (salida del toString)
		System.out.println(Archivo.verCursos());
	}

	public String toString() {
		return "Ver cursos";
	}
}