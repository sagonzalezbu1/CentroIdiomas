package control.controlMenu;

import java.util.*;
import java.awt.event.*;
import BaseDatos.Archivo;
import control.Main;
import control.controlPanel.RegistrarAdministrativoPanel;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Administrativo, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarAdministrativoMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		String tituloCriterios = "Criterio";
		String[] criteriosArray = {"Nombre: ","Apellido: ","Cedula: ","Correo: ","Contraseña: ","Codigo: "};
		String tituloValores = "Valores";
		String[] valoresArray = {null,null,null,null,null,null};
		boolean[] habilitado = {true,true,true,true,true,true};
		Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
		Main.ventanaUsuario.getPanelP().setControlador(new RegistrarAdministrativoPanel());
		Main.ventanaUsuario.getPanelP().descripcion("Permite registrar un administrativo al sistema");
		Main.ventanaUsuario.getPanelP().nombre("Registrar Administrativo");
		Main.ventanaUsuario.pack();		
	}
	
	/*Se piden los datos necesarios y se ingresan en la creación del objeto, con algunas verificaciones de por medio
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba el nombre: ");
		String nombre = entrada.next();
		System.out.println("Escriba el primer apellido: ");
		String apellido = entrada.next();
		System.out.println("Escriba la cedula: ");
		long cc = entrada.nextLong();
		System.out.println("Escriba el correo electronico: ");
		String correo = entrada.next();
		System.out.println("Escriba la contraseña que desee: ");
		String contraseña = entrada.next();
		System.out.println("Esciba el codigo necesario para ser Administrativo: ");
		String codigo = entrada.next();
		
		//Verifica que el código ingresado sea correcto
		if(Archivo.buscarAdministrativo(cc) == null && Archivo.buscarDocente(cc) == null && Archivo.buscarEstudiante(cc) == null && cc != 123) {
			if(codigo.equals(Administrativo.getCodigo())) {
				new Administrativo(nombre + " " + apellido, cc, correo, contraseña);
				System.out.println("\nSe ha registrado exitosamente.\n");
			}else {
				System.out.println("\nCodigo incorrecto.\n");
			}
		}
		else {
			System.out.println("\nYa se encuentra registrado un usuario con esa cédula.\n");
		}
		
	}
	
	Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú
	public String toString() {
		return"Registrar Administrativo";
	}*/
}