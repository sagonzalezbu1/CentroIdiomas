package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import BaseDatos.Archivo;
import control.OpcionDeMenu;
import control.controlPanel.RegistrarDocentePanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Docente, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarDocenteMenu implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("RegistrarDocente")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre: ","Apellido: ","Cedula: ","Correo: ","Contraseña: ","Codigo: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null,null,null};
			boolean[] habilitado = {true,true,true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new RegistrarDocentePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Permite registrar un docente al sistema");
			Main.ventanaUsuario.getPanelP().nombre("Registrar Docente");
			Main.ventanaUsuario.pack();	
		}
	}
}