package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* La clase 'VerEstudiantesCurso' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes registrados el curso que ha elegido para ver los estudiantes.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerEstudiantesCurso.*/
public class VerEstudiantesCurso implements ActionListener {
	private String nombre = "VerEstudiantesCurso";
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerEstudiantesCurso")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Nombre del curso: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	/*En este metodo verificamos si hay el curso al cual se quieren ver los estudiantes exixten por medio de lo que nos devuelve 'buscarCurso'. 
	*Si los hay, los mostramos los estudiantes de dicho curso, si no tiene estudiantes informamos de ello. Si el curso ingresado no exite, notificamo. 
	*Este metodo no recibe ningun parametro.*/
	/*public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso del cual quiere ver los estudiantes");
		String curso = entry.next();
		Curso course = Archivo.buscarCurso(curso);
		
		if (course == null) {
			System.out.println("\nEl curso '"+curso+"' no existe.\n");
		} else {
			System.out.println(Archivo.verEstudiantesCurso(curso));
		}

	}*/
	
	/* Sobreescribimos el metodo de 'Object''toString'.*/
	public String toString() {
		return "Ver estudiantes de un curso";
	}
}
