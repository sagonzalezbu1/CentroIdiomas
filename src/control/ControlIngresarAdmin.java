package control;

import java.awt.event.*;
import java.util.*;
import BaseDatos.Archivo;
import modelo.Usuarios.*;

public class ControlIngresarAdmin implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Administrador")) {
			long cedula =  Main.ventanaLogin.getCedula();
			String contraseña = Main.ventanaLogin.getContrasena();
			String mensaje= Archivo.ingresarAdmin(cedula, contraseña);
			if(mensaje.equals("Se ha iniciado sesion.")) {
				Main.ventanaLogin.ingresar();
				Main.ventanaUsuario.ingresar(Main.user.getProcesos(),Main.user.getNombre());
			}
			else {
				Main.ventanaLogin.borrar(mensaje);
			}
		}
	}

}
