package control.controlMenu;

import java.awt.event.*;
import BaseDatos.Archivo;
import control.Main;
import control.OpcionDeMenu;
import control.controlPanel.RegistrarDocentePanel;
import control.controlPanel.RegistrarEstudiantePanel;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Estudiante, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarEstudianteMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("RegistrarEstudiante")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre: ","Apellido: ","Cedula: ","Correo: ","Contraseña: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null,null};
			boolean[] habilitado = {true,true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new RegistrarEstudiantePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite registrar un estudiante al sistema");
			Main.ventanaUsuario.getPanelP().nombre("Registrar Estudiante");
			Main.ventanaUsuario.pack();	
		}
	}
	
	/*Se piden los datos necesarios y se ingresan en la creación del objeto, con 
	 * algunas verificaciones de por medio
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba su nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba su primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba su cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba su correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			new Estudiante(nombre + " " + apellido, cc, correo, contraseña);
			System.out.println("\nSe ha registrado exitosamente.\n");
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa cédula.\n");
		}
		
	}
	
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú
	public String toString() {
		return"Registrar Estudiante";
	}*/
}