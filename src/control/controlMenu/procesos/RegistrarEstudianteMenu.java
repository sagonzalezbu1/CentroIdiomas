package control.controlMenu.procesos;

import java.awt.event.*;


import control.controlPanel.procesos.RegistrarDocentePanel;
import control.controlPanel.procesos.RegistrarEstudiantePanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Invitado para crear una cuenta de tipo Estudiante, 
 * creando un objeto de este tipo con los datos que se ingresen.*/
public class RegistrarEstudianteMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("RegistrarEstudiante")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre: ","Apellido: ","Cedula: ","Correo: ","Contrase�a: "};
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