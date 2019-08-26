package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* La clase 'VerCertificados' es donde mostramos los certificados que tiene hasta el momento un estudiante, si quien lo realiza es de instancia 
 * diferente de la instancia 'Estudiante'. Por el contrario se mostraran los certificados que tiene el estudiante.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Estudiante' VerCertificados. 
 */
public class VerCertificados implements ActionListener{
	private String nombre="VerCertificados";
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerCertificados")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del estudiante: "};
			String[] valores = {"Ingrese La cedula del estudiante"};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
	/*Este metodo retorna el nombre que tiene la opcion de menu. Ademas sobreescribimos el metodo de 'OpcionDeMenu'. Este metodo no recibe ningun parametro.*/
	public String getNombre() {
		return nombre;
	}
	
	/*public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		//Verifica qué tipo de usuario verá los certificados
		if(Main.user instanceof Estudiante) {
			//Si es estudiante muestra sus certificados
			String aux = ((Estudiante)Main.user).verCertificados();
			if(aux.equals("")){
				System.out.println("\nUsted no tiene certificados.\n");
			}else {
				System.out.println("");
				System.out.println(aux);
			}
		}
		else {
			System.out.println("Introduzca el ID del estudiante del que quiere ver los certificados");
			long ID = entry.nextLong();
			Estudiante estudiante = Archivo.buscarEstudiante(ID);
			
			if(estudiante==null) {
				System.out.println("\nEste estudiante no esta registrado.\n");
			}else {
				String aux = estudiante.verCertificados();
				if(aux.equals("")){
					System.out.println("\nEste estudiante no tiene certificados.\n");
				}else {
					System.out.println(aux);
				}
			}
			
		}	
	}*/
	
	/* Sobreescribimos el metodo de 'Object''toString'.*/
	public String toString() {
		return "Ver Certificados";
	}
}
