package uiMain;

import BaseDatos.Archivo;
/* La clase 'VerTodosLosEstudiantes' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerTodosLosEstudiantes.
 */
public class VerTodosLosEstudiantes extends OpcionDeMenu {
	private String nombre = "VerTodosLosEstudiantes";
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro. 
	 */
	public String getNombre() {
		return nombre;
	}
	/*En este metodo verificamos si hay Estudiantes por medio de lo que nos devuelve 'verEstudiantes'. 
	 * Si los hay, los mostramos; sino informamos de ello al usuario. Este metodo no recibe ningun parametro. 
	 * */
	public void ejecutar() {
		if (Archivo.verEstudiantes().equals("\nEstudiantes:\n")) {
			System.out.println("No hay estudiantes registrados.\n");
		} else {
			System.out.println(Archivo.verEstudiantes());
		}
	}
	/* Sobreescribimos el metodo de 'Object''toString'
	 * */
	public String toString() {
		return "Ver todos los estudiantes";
	}
}
