package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.RemoveFuncionalidadPanel;
import defecto.Main;
import vista.FieldPanel;

/*Esta clase es usada por el Administrador para eliminar funcionalidades a 
 * los menús de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el método eliminarOpcion localizado en la clase MenuDeConsola.*/
public class RemoveFuncionalidadMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("RemoveFuncionalidad")) {
			String tituloCriterios = "Criterio";
			String tituloValores = "Valor";
			String[] criterios = { "Cedula del usuario: ", "Nombre de la funcionalidad: " };
			String[] valores = { null, null };
			boolean[] habilitado = { true, true };
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new RemoveFuncionalidadPanel());
			Main.ventanaUsuario.getPanelP().nombre("Remover funcionalidad de un usuario");
			Main.ventanaUsuario.getPanelP().descripcion("Ingresando la cedula del usuario al cual desea remover una funcionalidad,esta si es de ser posible, sera borrada");
			Main.ventanaUsuario.pack();

		}
	}

}
