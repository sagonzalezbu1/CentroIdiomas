package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles de cierto usuario.
 * 
 * En esta clase se ejecuta el método userSystemMenu localizado en la clase Administrador*/
public class VerMenuUsuario implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerMenuUsuario")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del usuario: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
		}

	}
	
	//Se muestran todas las funcionalidades del usuario especificado
	/*public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona a la cual quiere verle las funcionalidades: ");
		long IDuser = entry.nextInt();
		Usuario usuario = Archivo.buscarUsuario(IDuser);
		String texto = ((Administrador) Main.user).userSystemMenu(IDuser);
		
		if(usuario!=null) {
			System.out.println("\nLas opciones de menu de "+usuario.getNombre()+" cuya cedula es "+IDuser+" son: \n");
			System.out.println(texto);
		}else {
			System.out.println(texto);
		}
		
	}*/

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Funcionalidades del Usuario";
	}
}