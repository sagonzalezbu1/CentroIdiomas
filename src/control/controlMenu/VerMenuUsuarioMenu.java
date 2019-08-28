package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.VerMenuUsuarioPanel;
import defecto.Main;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles de cierto usuario.
 * 
 * En esta clase se ejecuta el método userSystemMenu localizado en la clase Administrador*/
public class VerMenuUsuarioMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerMenuUsuario")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del usuario: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new VerMenuUsuarioPanel());
			Main.ventanaUsuario.getPanelP().nombre("Ver menu de un usuario");
			Main.ventanaUsuario.getPanelP().descripcion("Recibe la cedula de un usuario y luego muestra el menu que este tiene");
			Main.ventanaUsuario.pack();
		}

	}
}