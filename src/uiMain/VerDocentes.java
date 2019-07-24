package uiMain;
import gestorAplicacion.Centro.Archivo;
/* La clase 'VerDocentes' es donde mostramos a los usuarios el nombre y la cedula todos los docentes que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerDocentes.
 */
public class VerDocentes extends OpcionDeMenu{
	private String nombre="VerDocentes";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		if (Archivo.verDocentes().equals("\nDocentes:\n")) {
			System.out.println("No hay docentes registrados.\n");
		} else {
			System.out.println(Archivo.verDocentes());
		}
	}

	public String toString() {
		return "Ver docentes";
	}
	
}
