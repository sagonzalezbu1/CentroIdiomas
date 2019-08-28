package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



import control.controlPanel.procesos.AddFuncionalidadPanel;
import control.controlPanel.procesos.VerHorarioEstudiantePanel;
import defecto.Main;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrador para agregar funcionalidades a 
 * los men�s de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el m�todo anadirOpcion localizado en la clase MenuDeConsola.*/
public class AddFuncionalidadMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("AddFuncionalidad")) {
			String Docentes= ((Administrador)Main.user).funcionalidadesDocentes();
			String Estudiantes=((Administrador)Main.user).funcionalidadesEstudiantes();
			String Administrativos=((Administrador)Main.user).funcionalidadesAdministrativos();
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Cedula del Usuario: ","Funcionalidad a a�adir: "};
			String[] valores = {null,null};
			boolean[] habilitado= {true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new AddFuncionalidadPanel());
			Main.ventanaUsuario.getPanelP().nombre("A�adir funcionalidad a un usuario");
			Main.ventanaUsuario.getPanelP().descripcion("Antes de a�adir una funcionalidad recuerde que solo puede a�adir las que se encuentran en alguna de estas listas, respectivamente. Ingrese el nombre sin espacios.\n\n"+ Docentes+"\n\n"+Estudiantes+"\n\n"+Administrativos);
			Main.ventanaUsuario.pack();
		}
	}
	
	
}