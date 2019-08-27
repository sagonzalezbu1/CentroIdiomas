package control.controlMenu;
import java.awt.event.*;

import control.Main;
import control.controlPanel.SolicitarCupoPanel;

/*En esta clase se ejecutan las acciones necesarias para que un usuario pueda solicitar
 * cupo a cursos que ya están llenos*/

public class SolicitarCupoMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("SolicitarCupo")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Tipo de la Solicitud: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new SolicitarCupoPanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite solicitar cupo a cursos no disponibles");
			Main.ventanaUsuario.getPanelP().nombre("Solicitar cupo");
			Main.ventanaUsuario.pack();
			
		}
	}
}
