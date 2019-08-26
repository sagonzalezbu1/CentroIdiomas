package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* La clase 'VerHorario' es donde mostramos el horario que tiene hasta en el momento un estudiante o un docente, si quien lo realiza es de instancia 
 * diferente la instancia 'Estudiante' o 'Docente'. Por el contrario se mostraran wl horario con el que cuenta.
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' o 'Docente' VerHorario.*/
public class VerHorarioDocente implements ActionListener {
	private String nombre = "VerHorario";
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerHorarioDocente")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del docente: "};
			String[] valores = {"Ingrese La cedula del docente"};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
	/* Este metodo verfica que tipo de usuario esta realizando la opcion. luego de ello procede a:
	 * si es estudiante, imprime el horario que tiene por medio de el metodo 'miHorario'
	 * si es docente, imprime el horario que tiene por medio de el metodo 'miHorario'
	 * si es de otro tipo de instancia, pide el documento del usuario(estudiante o docente) al cual quiere ver el horario que tiene, compruebe que este en 'Archivo'
	 * y de ser afirmativo, comunica el horario. De caso contrario, avisa que no se encuentra ningun usuario (estudiante o docente) con ese ID.*/
	/*public void ejecutar() {
		
		if (Main.user instanceof Estudiante) {
			System.out.println("");
			System.out.println(((Estudiante) Main.user).miHorario());
		} else if (Main.user instanceof Docente) {
			System.out.println(((Docente) Main.user).miHorario());
		} else {
			Scanner entry = new Scanner(System.in);
			System.out.println("Ingrese la cedula de quien quiere ver el horario: ");
			long ID = entry.nextLong();
			
			for (Docente docente : Archivo.getDocentes()) {
				if (docente.getCedula() == ID) {
					System.out.println(docente.miHorario());
					return;
				}
			}
			
			for (Estudiante estudiante : Archivo.getEstudiantes()) {
				if (estudiante.getCedula() == ID) {
					System.out.println("");
					System.out.println(estudiante.miHorario());
					return;
				}
			}
			
			System.out.println("\nNo se ha encontrado ningun usuario.\n");
		
		}
	}*/
	
	/* Sobreescribimos el metodo de 'Object''toString'. */
	public String toString() {
		return "Ver horario";
	}
}