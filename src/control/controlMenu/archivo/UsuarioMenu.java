package control.controlMenu.archivo;

import java.awt.event.*;
import control.*;
import control.controlPanel.*;
import control.controlPanel.archivo.UsuarioPanel;
import defecto.Main;

public class UsuarioMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Usuario")) {
			String tituloCriterios = "Criterio";
			String tituloValores = "Valor";
			String[] criterios = {"Nombre: ", "Cedula: ", "Correo: ", "Contraseña: "};
			String[] valores = {Main.user.getNombre(), "" + Main.user.getCedula(), Main.user.getCorreo(), Main.user.getContrasena()};
			boolean[] habilitado = {true, false, true, true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new UsuarioPanel());
			Main.ventanaUsuario.getPanelP().nombre("Usuario");
			Main.ventanaUsuario.getPanelP().descripcion("Perfil del Usuario");
			Main.ventanaUsuario.pack();
		}
	}
}
