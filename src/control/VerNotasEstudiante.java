package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* La clase 'VerNotas' es donde mostramos las notas que tiene hasta el momento y el acumulado de las mismas de un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran las notas que tiene el estudiante y el acumulado de las mismas.
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerNotas. */
public class VerNotasEstudiante implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerNotasEstudiante")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {"Ingrese La cedula del estudiante"};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
	/* Este metodo verfica que tipo de usuario esta realizando la opcion. Luego de ello procede a:
	 * si es estudiante, imprime las notas que tiene por medio de el metodo 'verNotas'
	 * si es de otro tipo de instancia, pide el documento del estudiante al cual quiere ver las notas que tiene, comprueba que el estudiante este en 'Archivo'
	 * y de ser afirmativo, notifica las notas. De caso contrario, avisa que no se encuentra ningun estudiante con ese ID.*/
	/*public void ejecutar() {
		
		if(Main.user instanceof Estudiante) {
			for(Curso curso : ((Estudiante) Main.user).getCurso()) {
				System.out.print(curso.getNombreCurso() + ": " + ((Estudiante) Main.user).verNotas(curso.getNombreCurso()) + "\n");
			}
		}
		else {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Ingrese la cédula del estudiante del que quiere ver las notas: ");
			long cedula = entrada.nextLong();
			
			for(Estudiante estudiante : Archivo.getEstudiantes()) {
				
				if(estudiante.getCedula()==cedula) {
					System.out.println("");
					for(Curso curso : estudiante.getCurso()) {
						System.out.print(curso.getNombreCurso() + ": " + estudiante.verNotas(curso.getNombreCurso()) + "\n");
					}
					System.out.println("");
					return;
				}
				
			}
			
			System.out.println("\nEl estudiante no se encuentra.\n");
			
		}
	}*/
	
	/* Sobreescribimos el metodo de 'Object''toString'. */
	public String toString() {
		return "Ver notas";
	}
}
