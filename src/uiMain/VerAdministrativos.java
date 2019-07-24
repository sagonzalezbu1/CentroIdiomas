package uiMain;
import gestorAplicacion.Centro.Archivo;
/* La clase 'VerAdministrativos' es donde mostramos a los usuarios el nombre y la cedula todos los administrativos que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerAdministrativos.
 */
public class VerAdministrativos extends OpcionDeMenu {
	private String nombre="VerAdministrativos";
	public String getNombre() {
		return nombre;
	}
	// En este metodo verificamos si hay administrativos por medio de lo que nos devuelve 'verAdministrativos'. 
	//Si los hay, los mostramos; sino informamos de ello al usuario. Este metodo no recibe ningun parametro. 
	public void ejecutar() {
		if (Archivo.verAdministrativos().equals("\nAdministrativos:\n")) {
			System.out.println("No hay administrativos registrados.\n");
		} else {
			System.out.println(Archivo.verAdministrativos());
		}
	}

	public String toString() {
		return "Ver administrativos";
	}
}
