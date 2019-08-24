package control;
import BaseDatos.Archivo;
/* La clase 'VerDocentes' es donde mostramos a los usuarios el nombre y la cedula todos los docentes que se encuentren en 'Archivo'. 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerDocentes.
 */
public class VerDocentes extends OpcionDeMenu{
	private String nombre="VerDocentes";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	/*En este metodo verificamos si hay docentes por medio de lo que nos devuelve 'VerDocentes'.Si los hay, los mostramos; sino informamos de ello al usuario. Este metodo no recibe ningun parametro.*/
	public void ejecutar() {
		if (Archivo.verDocentes().equals("\nDocentes:\n")) {
			System.out.println("No hay docentes registrados.\n");
		} else {
			System.out.println(Archivo.verDocentes());
		}
	}
	
	/* Sobreescribimos el metodo de 'Object''toString'. */
	public String toString() {
		return "Ver docentes";
	}
	
}
