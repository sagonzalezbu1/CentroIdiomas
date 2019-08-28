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
	
}