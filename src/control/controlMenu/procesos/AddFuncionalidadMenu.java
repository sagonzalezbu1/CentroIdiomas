package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



import control.controlPanel.procesos.AddFuncionalidadPanel;
import control.controlPanel.procesos.VerHorarioEstudiantePanel;
import defecto.Main;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrador para agregar funcionalidades a 
 * los menús de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el método anadirOpcion localizado en la clase MenuDeConsola.*/
public class AddFuncionalidadMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("AddFuncionalidad")) {
			String Docentes= ((Administrador)Main.user).funcionalidadesDocentes();
			String Estudiantes=((Administrador)Main.user).funcionalidadesEstudiantes();
			String Administrativos=((Administrador)Main.user).funcionalidadesAdministrativos();
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del Usuario: ","Funcionalidad a añadir: "};
			String[] valores = {null,null};
			boolean[] habilitado= {true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new AddFuncionalidadPanel());
			Main.ventanaUsuario.getPanelP().nombre("Añadir funcionalidad a un usuario");
			Main.ventanaUsuario.getPanelP().descripcion("Antes de añadir una funcionalidad recuerde que solo puede añadir las que se encuentran en alguna de estas listas, respectivamente. Ingrese el nombre sin espacios.\n\n"+ Docentes+"\n\n"+Estudiantes+"\n\n"+Administrativos);
			Main.ventanaUsuario.pack();
		}
	}
	
	
}