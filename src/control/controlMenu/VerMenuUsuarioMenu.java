package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Main;
import control.controlPanel.VerMenuUsuarioPanel;

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
		}

	}
}