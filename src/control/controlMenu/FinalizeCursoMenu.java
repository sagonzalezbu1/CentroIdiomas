package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import BaseDatos.Archivo;
import control.Main;
import control.OpcionDeMenu;
import control.controlPanel.FinalizeCursoPanel;
import control.controlPanel.HacerSugerenciaPanel;
import control.controlPanel.RegistrarEstudiantePanel;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.NoHayNotas;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo as�
 * como cerrar el per�odo de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el m�todo finalizeCurso localizado en la clase Curso.*/
public class FinalizeCursoMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("FinalizeCurso")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Nombre del curso: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new FinalizeCursoPanel());
			Main.ventanaUsuario.getPanelP().nombre("Finalizar Curso");
			Main.ventanaUsuario.getPanelP().descripcion("Permite finalizar un curso de los que ya estan abierto en el CDI.");
			Main.ventanaUsuario.pack();
		}
	}
	
	/*private String nombre="FinalizeCurso";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro
	public String getNombre() {
		return nombre;
	}
	
	/*Se verifica que los datos para la ejecuci�n del m�todo sean correctos, 
	 * luego se busca el curso, si se encuentra se cierra el per�odo de 
	 * calificaciones de este
	
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso que desea finalizar: ");
		String nombre = entry.next();
		Curso cursofinalizar = null;
		
		for (Curso curso : Archivo.getCursos()) {
			if (curso.getNombreCurso().equals(nombre)) {
				cursofinalizar = curso;
				break;
			}
		}
		
		if (cursofinalizar == null) {
			System.out.println("\nNo se encontr� el curso\n");
		} else {
			cursofinalizar.finalizeCurso();
			System.out.println("\nEl curso ha sido finalizado.\n");
		}
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�
	public String toString() {
		return "Finalizar curso";
	}*/
}