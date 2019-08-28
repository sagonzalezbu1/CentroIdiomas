package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.FuncionalidadIncorrecta;
import modelo.excepciones.modelo.NoExisteUsuario;
import vista.FieldPanel;
import vista.ventanaUsuario;

public class RemoveFuncionalidadPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del usuario: ");
				String funcionalidad = Main.ventanaUsuario.getPanelP().getValue("Nombre de la funcionalidad: ");
				String mensaje = (new Administrador()).removerFuncionalidad(Long.parseLong(cedula), funcionalidad);
				Main.ventanaUsuario.Popup2(mensaje);
				Main.ventanaUsuario.setPanelP();

			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteUsuario excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (FuncionalidadIncorrecta excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
