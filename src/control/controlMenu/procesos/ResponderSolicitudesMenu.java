package control.controlMenu.procesos;

import java.awt.event.*;
import control.controlPanel.*;
import control.controlPanel.procesos.ResponderSolicitudesPanel;
import defecto.*;
import modelo.Centro.*;

/*Esta clase es usada por Administrativo para responder a las solicitudes de cupo
 * que hagan los estudiantes a los cursos que no tengan cupos.*/
public class ResponderSolicitudesMenu implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("ResponderSolicitudes")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Tipo de solicitud: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null};
			boolean[] habilitado = {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().nombre("Responder solicitudes");
			Main.ventanaUsuario.getPanelP().setControlador(new ResponderSolicitudesPanel());
			Main.ventanaUsuario.getPanelP().descripcion("Responde solicitudes. Ingrese alguno de estos estos tipos: \n"+ Solicitud.verSolicitudes());
			Main.ventanaUsuario.pack();
		}
	}
	

	/*private String nombre = "ResponderSolicitudes";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro
	public String getNombre() {
		return nombre;
	}Se muestran por pantalla las solicitudes disponibles y se da la opci�n de aceptar, rechazar e ignorar.
	 * Al aceptar se matricula al estudiante y se elimina la solicitud, al rechazar s�lo se elimina la solicitud, 
	 * y al ignorar s�lo se sale de la opci�n.*/
	/*public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		
		if(!Archivo.verSolicitudes().equals("\nSolicitudes:\n")) {
		System.out.println(Archivo.verSolicitudes());
		System.out.println("Ingrese el tipo de la materia que desea responder solicitudes: ");
		String tipo = entry.next();
		ArrayList<Solicitud> solicitudes = Archivo.getSolicitudes().get(tipo);
		// Eval�a cada solicitud
		
		if (solicitudes != null) {
			
			while(solicitudes.size() > 0) {
				
				Curso course = Archivo.cursoDisponibilidad(tipo);
				Solicitud solicitud= solicitudes.get(0);
				System.out.println("Tiene una solicitud de: " + solicitud.getEstudiante().getCedula());
				System.out.println("Ingrese: 1 para aceptar, 2 para rechazar, 3 para no responder m�s solicitudes");
				int opcion = entry.nextInt();
				
				if (opcion == 1) {
					
					if (course == null) {
						System.out.println("\nSe creara un curso.");
						(Main2.funcionalidades.get("CrearCurso")).ejecutar();
						course = Archivo.cursoDisponibilidad(tipo);
						solicitud.aceptarSolicitud(course);
						System.out.println("\nSe ha aceptado la solicitud exitosamente.\n");
					} else {
						solicitud.aceptarSolicitud(course);
						System.out.println("\nSe ha aceptado la solicitud exitosamente.\n");
					}
					
				}
				else if (opcion == 2) {
					solicitud.rechazarSolicitud();
					System.out.println("\nSe ha rechazado la solicitud exitosamente.\n");
				}
				
				else {
					System.out.println("\nHa decidido no responder mas solicitudes.\n");
					return;
				}
			}
			System.out.println("No hay mas solicitudes de este tipo.\n");
		} else {
			System.out.println("No hay solicitudes de este tipo.\n");
		}
	} else {
			System.out.println("\nNo hay solicitudes.\n");
		}

	}*/

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Responder solicitudes";
	}

	
}