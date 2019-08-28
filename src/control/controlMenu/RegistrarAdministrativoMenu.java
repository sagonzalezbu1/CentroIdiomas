package control.controlMenu;

import java.util.*;
import java.awt.event.*;

import control.controlPanel.RegistrarAdministrativoPanel;
import defecto.Main;
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
}